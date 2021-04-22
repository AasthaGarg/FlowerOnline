import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  constructor(private cs:CustomerServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  name='';
  email='';
  des='';
  contact():void{
    var contact = {
      name: this.name,
      email: this.email,
      des:this.des
    };
    this.cs.contactUs(contact).subscribe(
      res => {
        console.log(res);
      }
    );
    this.router.navigate(['customers/products']);
  }

}
