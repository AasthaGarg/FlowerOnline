import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';
import { SharedServiceService } from '../shared-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private cs: CustomerServiceService,
    private router: Router,
    private ss: SharedServiceService) { }

  ngOnInit(): void {
  }

  uName = '';
  pass = '';
  signIn = true;
  err='';
  login(): void {
    var data = {
      fname: this.uName,
      password: this.pass
    };
    this.cs.login(data).subscribe((data1: any) => {
      console.log(data1);
      if (data1 != null) {
        this.ss.isLoggedin = true;
        this.ss.userName = data1.fname;
        this.ss.userDetails = data1;
        if (this.ss.cartItem.length != 0) {
          var userDetails= this.ss.userDetails;
          var list:Array<any>=[];
          this.ss.cartItem.forEach(element => {
            var data={
              ccid:{
                uid:userDetails.uid
              },
              cpid:{
                pid:element.pid
              },
              name: element.name,
              image: element.image,
              description: element.description,
              size: element.size,
              price: element.price,
              category: element.category,
              count: element.count,
              cartCount:element.cartCount,
              totalPrice: element.totalPrice,
              fname:userDetails.fname,
              lname: userDetails.lname,
              userID: userDetails.userID,
              mobile: userDetails.mobile,
              city: userDetails.city,
              country: userDetails.country
            };
            list.push(data);
          });
          this.cs.addToCartMultiple(list).subscribe((result:any)=>{
            if (this.ss.isLoginFromCheckout != true) {
              this.router.navigate(["customers/products"]);
            } else {
              this.ss.finalItem=result;
              this.router.navigate(["customers/payment"]);
            }
          }); 
        } else {
          this.router.navigate(["customers/products"]);
        }

      }else{
        this.err="Login Failed!";
      }
    })
  }

  cPass='';
  pass1='';
  uName1='';
  err1='';
  forgotPass():void{
   this.err1='';
    if(this.pass1==this.cPass){
      var data={
        fname: this.uName1,
        password: this.pass1

      }
      this.cs.forgotPassword(data).subscribe((result:any)=>{
        console.log(result);
        if(result=="Success"){
          this.signIn = true;
        }else{
          this.err1=result;
        }
      })
    }else{
      this.err1="Password mismatched";
    }
    
  };

}
