import { Component, OnInit } from '@angular/core';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-view-location',
  templateUrl: './view-location.component.html',
  styleUrls: ['./view-location.component.css']
})
export class ViewLocationComponent implements OnInit {

  constructor(private as:AdminService) { }

  ngOnInit(): void {
    this.allLocation();
  }
  public pList: any = [];
  public tempList: any = [];
  pageNumber = 1;
  pageSize = 8;
  errMsg = '';
  
  allLocation():void{
    this.as.allLocation().subscribe((data: any) => {
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

  
  previous(): void {
    if (this.pageNumber != 1) {
      this.pageNumber -= 1;
      this.tempList = this.pList.slice(this.pageSize * (this.pageNumber - 1), (this.pageSize * (this.pageNumber - 1)) + this.pageSize);
    }
  }

  selectedItem: any = {
    "id": 0,
    "name": "",
    "phone": "",
    "address": "",
  };

  editLocation(x: any): void {
    this.selectedItem = {
      "id": x.id,
      "name": x.name,
      "phone": x.phone,
      "address": x.address,
      
    };
    
  }
  selectedId = 0;
  deleteLocation(x: any): void {
    this.selectedId = x.id;
    
  }
  updateLocation(): void {
    this.as.updateLocation(this.selectedItem).subscribe((data: any) => {
      if (data !=null) {
        document.getElementById("closeModal")?.click();
        this.allLocation();
      }
    });
    
  }
  deleteLocationbyId(): void {
    var data = {
      id: this.selectedId
    }
    this.as.deleteLocation(data).subscribe((data1: any) => {
      if (data1== "Success") {
        document.getElementById("closeModal1")?.click();
        this.allLocation();
      }
    });
  }


}
