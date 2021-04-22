import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/customers/customer-service.service';
import { Router } from '@angular/router';
import { SharedServiceService } from 'src/app/customers/shared-service.service';


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
  uName='';
  pass='';
  errMsg='';
  login():void{
    if(this.uName=="admin" && this.pass=="admin"){
      this.router.navigate(["admin/"]);
    }else{
      this.errMsg="Invalid userId or password"
    }
  }

}
