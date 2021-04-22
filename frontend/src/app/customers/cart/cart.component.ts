import { Component, OnInit } from '@angular/core';
import { SharedServiceService } from '../shared-service.service';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  constructor(private ss: SharedServiceService, private cs: CustomerServiceService,
    private router: Router) { }
  items: Array<any> = [];
  ngOnInit(): void {
    this.items = this.ss.cartItem;
  }

  getTotalPrice(): string {
    var result = 0;
    this.items.forEach(element => {
      result = result + element.totalPrice;
    });
    return result.toString();
  }

  minusCount(item: any): void {
    var isLoggedIn = this.ss.isLoggedin;
    if (item.cartCount != 1) {
      item.cartCount = item.cartCount - 1;
      item.totalPrice = item.price * item.cartCount;
      if (isLoggedIn) {
        this.cs.updateCart(item).subscribe((result: any) => {
          this.ss.cartItem = this.items;
        })
      } else {
        this.ss.cartItem = this.items;
      }
    }
  }
  plusCount(item: any): void {
    var isLoggedIn = this.ss.isLoggedin;
    if (item.cartCount != item.count) {
      item.cartCount = item.cartCount + 1;
      item.totalPrice = item.price * item.cartCount;
      if (isLoggedIn) {
        this.cs.updateCart(item).subscribe((result: any) => {
          this.ss.cartItem = this.items;
        })
      } else {
        this.ss.cartItem = this.items;
      }
    }
  }
  removeItem(item: any,i:number) {
    var isLoggedIn = this.ss.isLoggedin;
    if (isLoggedIn) {
      this.cs.deleteCart(item).subscribe((result: any) => {
        this.items.splice(i,1);
        this.ss.cartItem = this.items;
      });
    } else {
      this.items.splice(i,1);
      this.ss.cartItem = this.items;
    }
  }
  placeOrder():void{
    var isLoggedIn = this.ss.isLoggedin;
    if (isLoggedIn) {
      this.ss.isLoginFromCheckout=false;
      this.ss.finalItem=this.ss.cartItem;
      this.router.navigate(["customers/payment"]);
    }else {
      this.ss.isLoginFromCheckout=true;
      this.router.navigate(["customers/login"]);
    }
  }
}
