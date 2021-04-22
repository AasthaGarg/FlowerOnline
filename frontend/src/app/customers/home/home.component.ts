import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';
import { SharedServiceService } from '../shared-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private cs: CustomerServiceService,
    private ss: SharedServiceService,
    private router:Router) { }

  ngOnInit(): void {
    this.getAllProducts();
    console.log(this.ss.isLoggedin);
    if(this.ss.isLoggedin){
      this.getAllCart();
    }
  }
  loggedInFlag=this.ss.isLoggedin;
  sd = '0';
  pList=[];
  getAllProducts(): void {
    this.cs.getAllProductWithImage().subscribe((data: any) => {
      console.log(data);
      this.pList = data;
    }); 
    /* this.cs.getProducts().subscribe((data: any) => {
      this.pList = data
    }); */
  }
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
  getDetails(name: String): void {
      this.ss.pName = name;
      this.router.navigate(['customers/details']);
    
  }
  filterChange(): void {
    if (this.sd == '0') {
      this.getAllProducts();
    } else if (this.sd == '1' || this.sd == '2') {
      var data = {
        category: "all",
        size: this.sd == '1' ? "Asc" : "Desc"
      }
      this.cs.sortByPrice(data).subscribe((data2: any) => {
        this.pList = data2
      });
    } else {
      var data = {
        category: "all",
        size: this.sd == '4' ? "Asc" : "Desc"
      }
      this.cs.sortBySize(data).subscribe((data1: any) => {
        this.pList = data1
      });
    }
  }
}
