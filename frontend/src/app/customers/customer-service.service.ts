import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http: HttpClient) { }
  endpoint = 'http://localhost:8008/';
  getProducts(): Observable<any> {
    return this.http.get(this.endpoint + 'getAllProduct');
  }
  getAllProductWithImage(): Observable<any> {
    return this.http.get(this.endpoint + 'getAllProductWithImage');
  }
  getProductsbyName(name:String): Observable<any> {
    var data={name:name};
    return this.http.post(this.endpoint + 'getProductByName',data,{responseType: 'json'});
  }
  getProductsbyCategory(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'getByCategory',data,{responseType: 'json'});
  }
  updateProduct(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'updateProduct',data,{responseType: 'text'});
  }

  sortBySize(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'sortBySize',data,{responseType: 'json'});
  }
  sortByPrice(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'sortByPrice',data,{responseType: 'json'});
  }
  login(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'login',data,{responseType: 'json'});
  }
  forgotPassword(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'forgotPass',data,{responseType: 'text'});
  }
  register(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addCustomer',data,{responseType: 'text'});
  }
  addToCart(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addToCart',data,{responseType: 'json'});
  }
  addToCartMultiple(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addToCartMultiple',data,{responseType: 'json'});
  }
  getCartById(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'getCartById',data,{responseType: 'json'});
  }
  updateCart(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'updateCart',data,{responseType: 'json'});
  }
  deleteCart(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'deleteCart',data,{responseType: 'text'});
  }
  addSell(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addSell',data,{responseType: 'text'});
  }
  sendfeedback(feedback:any): Observable<any> {
    return this.http.post(this.endpoint+`sendfeedback`, feedback,{responseType: 'text'});
  }

  getfeedback(feedback:any): Observable<any> {
    return this.http.post(this.endpoint+`getfeedback`, feedback,{responseType: 'text'});
  }

  sendOrderEmail(feedback:any): Observable<any> {
    return this.http.post(this.endpoint+ `sendOrderEmail`, feedback,{responseType: 'text'});
  }

  contactUs(feedback:any): Observable<any> {
    return this.http.post(this.endpoint+`contactUs`, feedback,{responseType: 'text'});
  }

  sendRegisterEmail(customer: any): Observable<any> {
    return this.http.post<any>(this.endpoint+`sendRegisterEmail`, customer);
  }

  allLocation():Observable<any> {
    return this.http.get(this.endpoint+`findAllLocations`,{responseType: 'json'});
  }

}
