import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient) { }
  endpoint = 'http://localhost:8008/';
  getProducts(): Observable<any> {
    return this.http.get(this.endpoint + 'getAllProductWithImage');
  }
  getAllCustomer(): Observable<any> {
    return this.http.get(this.endpoint + 'getAllCustomer');
  }
  listAllCity(): Observable<any> {
    return this.http.get(this.endpoint + 'listAllCity');
  }
  listAllCountry(): Observable<any> {
    return this.http.get(this.endpoint + 'listAllCountry');
  }
  addProduct(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addProduct',data,{responseType: 'json'});
  }
  getProductsbyCategory(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'getByCategory',data,{responseType: 'json'});
  }
  addProductWithImage(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addProductWithImage',data,{responseType: 'text'});
  }
  updateProduct(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'updateProduct',data,{responseType: 'text'});
  }
  getCustomerByCity(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'getCustomerByCity',data,{responseType: 'json'});
  }
  getCustomerByCountry(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'getCustomerByCountry',data,{responseType: 'json'});
  }
  sellReports(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'sellReports',data,{responseType: 'json'});
  }
  deleteProduct(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'deleteProduct',data,{responseType: 'text'});
  }
  addLocation(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'addLocation',data,{responseType: 'json'});
  }
  allLocation(): Observable<any> {
    return this.http.get(this.endpoint + 'findAllLocations',{responseType: 'json'});
  }
  deleteLocation(data:any):Observable<any> {
    return this.http.post(this.endpoint + 'deleteLocation',data,{responseType: 'text'});
  }
  updateLocation(data:any): Observable<any> {
    return this.http.post(this.endpoint + 'editLocation',data,{responseType: 'text'});
  }
}
