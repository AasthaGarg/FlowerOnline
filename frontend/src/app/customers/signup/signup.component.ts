import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private cs: CustomerServiceService,
    private router: Router) { }

  ngOnInit(): void {
  }
  fn='';
  ln='';
  em='';
  pass='';
  mo='';
  ci='';
  co='';
  errMsg='';
  register(): void{
    var data={
      fname: this.fn,
      lname: this.ln,
      email : this.em,
      password : this.pass,
      mobile : this.mo,
      city : this.ci,
      country : this.co
    };
    this.cs.register(data).subscribe((data1:any) =>{
      console.log(data1);
      if(data1=="Success"){
        this.router.navigate(['customers/login']);        
      }else{
        this.errMsg=data1;
      }
    });
    this.cs.sendRegisterEmail(data).subscribe((res:any)=>{
      console.log(res);
    });
  }

}
