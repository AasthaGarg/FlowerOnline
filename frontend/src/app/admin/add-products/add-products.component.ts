import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from 'src/app/customers/customer-service.service';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {

  constructor(private as: AdminService,
    private router: Router) { }

  ngOnInit(): void {
  }
  pn = '';
  de = '';
  size = '';
  pr = '';
  ca = '';
  co = '';
  errMsg = '';
  //selectedFile= this.url;
  /*public onFileChanged(event: any) {
    //this.selectedFile = event.target.files[0];
    this.selectedFile = ;
  }*/
  addProduct(): void {
    this.errMsg = '';
    var data = {
      name: this.pn,
      description: this.de,
      size: this.size,
      price: this.pr,
      category: this.ca,
      count: this.co
    };
    
    this.as.addProductWithImage(data).subscribe((data1: any) => {
      console.log(data1);
      if (data1 == "Success") {
        this.errMsg = data1.msg;
        this.pn = '';
        this.de = '';
        this.size = '';
        this.pr = '';
        this.ca = '';
        this.co = '';
        this.router.navigate(["admin/view"]);
      } else {
        this.errMsg = data1;
      }
    }) 
  }

}
