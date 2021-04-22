import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor( private router: Router,private cd:ChangeDetectorRef) { }

  ngOnInit(): void {
    
  }
  ngAfterViewChecked(){
    var url=this.router.routerState.snapshot.url;
    if(url=='/admin/login'){
      this.isLogin=true;
      document.getElementById("body-content")!.style.paddingLeft = "0px";
    } else {
      this.isLogin=false;
      document.getElementById("body-content")!.style.paddingLeft = "200px";
    }
    this.cd.detectChanges();
  }
  isLogin=true;
  checkTab(x:string):boolean{
    var url=this.router.routerState.snapshot.url;
    if(url==('/admin/'+x)){
      return true;
    }else{
      return false;
    }
  }
  logout(){
    this.isLogin=false;
      document.getElementById("body-content")!.style.paddingLeft = "200px";
  }
}
