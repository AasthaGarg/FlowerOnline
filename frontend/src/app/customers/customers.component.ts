import { Component, OnInit, OnChanges, AfterContentInit, AfterContentChecked, AfterViewChecked, AfterViewInit, OnDestroy, ChangeDetectorRef } from '@angular/core';
import { SharedServiceService } from './shared-service.service';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit,AfterViewChecked{

  constructor( private ss: SharedServiceService,private cd:ChangeDetectorRef) { }

  ngOnInit(): void {
    
  }
  
  ngAfterViewChecked(){
    this.loggedInFlag=this.ss.isLoggedin;
    this.fname=this.ss.userName;
    this.cartLength=this.ss.cartItem.length;
    this.cd.detectChanges();
  }
  cartLength=0;
  loggedInFlag!:boolean;
  fname='';
  openNav(): void {
    document.getElementById("mySidenav")!.style.width = "200px";
  }
  
  closeNav(): void {
    document.getElementById("mySidenav")!.style.width = "0";
  }

  logout(){
    this.ss.isLoggedin = false;
    this.ss.userName = '';
    this.ss.userDetails = {};
    this.ss.cartItem=[];
    document.getElementById("mySidenav")!.style.width = "0";
  }


}
