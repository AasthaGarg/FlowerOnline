import { Component, OnInit } from '@angular/core';
import { SharedServiceService } from '../shared-service.service';

@Component({
  selector: 'app-shop',
  templateUrl: './shop.component.html',
  styleUrls: ['./shop.component.css']
})
export class ShopComponent implements OnInit {

  constructor( private ss: SharedServiceService) { }

  ngOnInit(): void {

  }
 

  setCategory(x:any):void{
    if(x=='1'){
      this.ss.category='Marriage';
    }else if(x=='2'){
      this.ss.category='Anniversary';
    }else{
      this.ss.category='Birthday';
    }
  }

}
