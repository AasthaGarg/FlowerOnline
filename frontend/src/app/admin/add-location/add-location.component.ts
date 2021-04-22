import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-add-location',
  templateUrl: './add-location.component.html',
  styleUrls: ['./add-location.component.css']
})
export class AddLocationComponent implements OnInit {

  constructor(private as:AdminService,private router:Router) { }

  name='';
  phone='';
  address='';

  ngOnInit(): void {
  }

  addLocation():void{
    var data={
      name:this.name,
      phone:this.phone,
      address:this.address
    };

    this.as.addLocation(data).subscribe((res)=>{
      console.log(res);
    });
    this.router.navigate(['admin/viewloc']);
  }

}
