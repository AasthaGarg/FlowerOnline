import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SharedServiceService {

  constructor() { }
  pName : String;
  isLoggedin : boolean= false;
  userName : string;
  category :string;
  cartItem=[];
  finalItem=[];
  userDetails: any;
  isLoginFromCheckout : boolean= false;
}
