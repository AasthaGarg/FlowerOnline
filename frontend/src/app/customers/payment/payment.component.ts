import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';
import { SharedServiceService } from '../shared-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private cs: CustomerServiceService, private router: Router,
    private ss: SharedServiceService) { }


  ngOnInit(): void {
    this.finalItems = this.ss.finalItem;
    console.log(this.finalItems);
    if(this.ss.isLoggedin){
      this.getAllCart();
    }
  }
  finalItems: Array<any> = []
  getAllCart(): void {
    var data={
      ccid:{
        uid:this.ss.userDetails.uid
      }
    };
    this.cs.getCartById(data).subscribe((data: any) => {
      this.ss.cartItem = data
    });
  }
  paymemt():void{
    for (let i = 0; i < this.finalItems.length; i++) {
      var data={
          suid:{
            uid:this.ss.userDetails.uid
          },
          spid:{
            pid:this.finalItems[i].cpid.pid
          },
          count: this.finalItems[i].cartCount,
          amount: this.finalItems[i].totalPrice
      }
      this.cs.addSell(data).subscribe((res:any)=>{
        this.cs.deleteCart(this.finalItems[i]).subscribe((res1:any)=>{
          var d= {
              pid:this.finalItems[i].cpid.pid,
              name: this.finalItems[i].name,
              image: this.finalItems[i].image,
              description: this.finalItems[i].description,
              size: this.finalItems[i].size,
              price: this.finalItems[i].price,
              category: this.finalItems[i].category,
              count: this.finalItems[i].count-this.finalItems[i].cartCount,
          }
          this.cs.updateProduct(d).subscribe((res2:any)=>{
            if(i==(this.finalItems.length-1)){
              this.router.navigate(["customers/review"]);
            }
          })
        })
      });
    }
  }
  getTotalPrice(): string {
    var result = 0;
    this.finalItems.forEach(element1 => {
      result = result + element1.totalPrice;
    });
    return result.toString();
  }

}
