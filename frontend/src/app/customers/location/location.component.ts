import { Component, OnInit } from '@angular/core';
import { CustomerServiceService } from '../customer-service.service';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css']
})
export class LocationComponent implements OnInit {

  constructor(private cs:CustomerServiceService) { }
  
  public pList: any = [];
  public tempList: any = [];
  pageNumber = 1;
  pageSize = 3;

  ngOnInit(): void {
    this.getLocation();
  }
  
  getLocation():void{
    this.cs.allLocation().subscribe((res)=>{
      console.log(res);
      this.pList = res;
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

}
