import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';
import { SharedServiceService } from '../shared-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  constructor(private cs: CustomerServiceService,
    private ss: SharedServiceService,
    private router: Router) { }

    pList=[];
    selectedItem: any ={};
  ngOnInit(): void {
   
    var selectedName=this.ss.pName;
    this.cs.getProductsbyName(selectedName).subscribe((data : any)=>
    {
    this.pList=data;
    console.log(this.pList);
    });
  }

  disabled='';
  selectItem(item: any): void {
    this.selectedItem=item;
    this.disabled='1';
  }
  addToCart():void{
    var isLoggedIn=this.ss.isLoggedin;
    var userDetails= this.ss.userDetails;
    console.log(userDetails);
    //this.selectedItem['cartCount']=1;
    if(isLoggedIn){
      var data={
        ccid:{
          uid:userDetails.uid
        },
        cpid:{
          pid:this.selectedItem.pid
        },
        name: this.selectedItem.name,
        description: this.selectedItem.description,
        size: this.selectedItem.size,
        price: this.selectedItem.price,
        category: this.selectedItem.category,
        count: this.selectedItem.count,
        cartCount:1,
        totalPrice: this.selectedItem.price,
        fname:userDetails.fname,
        lname: userDetails.lname,
        mobile: userDetails.mobile,
        city: userDetails.city,
        country: userDetails.country
      }
      this.cs.addToCart(data).subscribe((result:any) =>{
        this.ss.cartItem.push(result); 
        this.router.navigate(['customers/products']);
      });
      
    } else {
      this.selectedItem['cartCount']=1;
      this.selectedItem['totalPrice']= this.selectedItem.price;
      this.ss.cartItem.push(this.selectedItem);  
      this.router.navigate(['customers/products']);
    }
  }


}
