import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';
import { Router } from '@angular/router';
import { $ } from 'protractor';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  constructor(private as: AdminService, private router: Router) { }

  ngOnInit(): void {
    this.getAllProducts();
  }
  public pList: any = [];
  public tempList: any = [];
  pageNumber = 1;
  pageSize = 5;
  errMsg = '';
  
  getAllProducts(): void {
    this.as.getProducts().subscribe((data: any) => {
      console.log(data);
      this.pList = data;
      this.tempList = this.pList.slice(this.pageSize * (this.pageNumber - 1), (this.pageSize * (this.pageNumber - 1)) + this.pageSize)
    });
  }
  next(): void {
    var l = this.pList.length;
    var a = Math.floor(l / this.pageSize);
    var b = l % this.pageSize;
    if (b != 0) {
      a = a + 1;
    }
    if (this.pageNumber != a) {
      this.pageNumber += 1;
      this.tempList = this.pList.slice(this.pageSize * (this.pageNumber - 1), (this.pageSize * (this.pageNumber - 1)) + this.pageSize);
    }
  }

  filterText = 'Apu';
  previous(): void {
    if (this.pageNumber != 1) {
      this.pageNumber -= 1;
      this.tempList = this.pList.slice(this.pageSize * (this.pageNumber - 1), (this.pageSize * (this.pageNumber - 1)) + this.pageSize);
    }
  }

  selectedItem: any = {
    "pid": 29,
    "name": "Apurba",
    "image": "../../../assets/flower6.jfif",
    "description": "flower",
    "size": "s",
    "price": 3000,
    "category": "Anniversary",
    "date": "2021-03-28T14:42:19.845+00:00",
    "count": 10
  };
  editProduct(x: any): void {
    this.selectedItem = {
      "pid": x.pid,
      "name": x.name,
      "image": x.image,
      "description": x.description,
      "size": x.size,
      "price": x.price,
      "category": x.category,
      "date": x.date,
      "count": x.count
    };
    
  }
  selectedId = 0;
  deleteProduct(x: any): void {
    this.selectedId = x.pid;
    
  }
  updateProduct(): void {
    this.as.updateProduct(this.selectedItem).subscribe((data: any) => {
      if (data == "Success") {
        document.getElementById("closeModal")?.click();
        this.getAllProducts();
      }
    });
    
  }
  deleteProductbyId(): void {
    var data = {
      pid: this.selectedId
    }
    this.as.deleteProduct(data).subscribe((data1: any) => {
      if (data1== "Success") {
        document.getElementById("closeModal1")?.click();
        this.getAllProducts();
      }
    });
  }

}
