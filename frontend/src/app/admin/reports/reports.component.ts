import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {

  constructor(private as: AdminService) { }

  ngOnInit(): void {
    this.sd = 'today';
    this.ca='Birthday';
    this.filterChange();
    this.as.getAllCustomer().subscribe((res: any) => {
      this.custList = res;
    });
    this.as.listAllCity().subscribe((res: any) => {
      this.cityList = res;
    });
    this.as.listAllCountry().subscribe((res: any) => {
      this.countryList = res;
    });
    var data={category: this.ca};
    this.as.getProductsbyCategory(data).subscribe((data1: any) => {
      this.catList = data1;
    });
  }
  sd = 'today';
  selectedCity = '';
  selectedCountry = '';
  sList: Array<any> = [];
  custList: Array<any> = [];
  cityList: Array<any> = [];
  countryList: Array<any> = [];
  catList: Array<any> = [];
  filterChange() {
    var data = {
      msg: this.sd
    }
    this.as.sellReports(data).subscribe((res: any) => {
      this.sList = res;
    });
  }
  filterCity() {
    if (this.selectedCity == '') {
      this.as.getAllCustomer().subscribe((res: any) => {
        this.custList = res;
      });
    } else {

      var data = {
        city: this.selectedCity
      }
      this.as.getCustomerByCity(data).subscribe((res: any) => {
        this.custList = res;
      });
    }
  }
  filterCon() {
    if (this.selectedCountry == '') {
      this.as.getAllCustomer().subscribe((res: any) => {
        this.custList = res;
      });
    } else {
      var data = {
        country: this.selectedCountry
      }
      this.as.getCustomerByCountry(data).subscribe((res: any) => {
        this.custList = res;
      });
    }
  }
  ca='Birthday';
  filterCategory(){
    var data={category: this.ca};
    this.as.getProductsbyCategory(data).subscribe((data1: any) => {
      this.catList = data1;
    });
  }
}
