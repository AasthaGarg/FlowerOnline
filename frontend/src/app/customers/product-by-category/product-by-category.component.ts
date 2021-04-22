import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CustomerServiceService } from '../customer-service.service';
import { SharedServiceService } from '../shared-service.service';

@Component({
  selector: 'app-product-by-category',
  templateUrl: './product-by-category.component.html',
  styleUrls: ['./product-by-category.component.css']
})
export class ProductByCategoryComponent implements OnInit {

  constructor(private cs: CustomerServiceService,
    private ss: SharedServiceService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProductsbyCategory();
  }

  sd = '0';
  public pList: any=[];
  getProductsbyCategory(): void {
    var data={category: this.ss.category};
    
    this.cs.getProductsbyCategory(data).subscribe((data1: any) => {
      this.pList = data1;
    });
  }
  getDetails(name: String): void {
    
      this.ss.pName = name;
      this.router.navigate(['customers/details']);
    
  }
  filterChange(): void {
    if (this.sd == '0') {
      this.getProductsbyCategory();
    } else if (this.sd == '1' || this.sd == '2') {
      var data = {
        category: this.ss.category,
        size: this.sd == '1' ? "Asc" : "Desc"
      }
      this.cs.sortByPrice(data).subscribe((data2: any) => {
        this.pList = data2
      });
    } else {
      var data = {
        category: this.ss.category,
        size: this.sd == '4' ? "Asc" : "Desc"
      }
      this.cs.sortBySize(data).subscribe((data3: any) => {
        this.pList = data3;
      });
    }
  }

}
