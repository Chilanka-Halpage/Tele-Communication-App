import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseURL = environment.baseServiceUrl;

  constructor(private _http: HttpClient) { }

  createCustomer(customer: any): Observable<any> {
    return this._http.post(`${this.baseURL}api/customers`, customer, {
      responseType: 'text' as 'json'
    });
  }

  createPaymet(pay: any): Observable<any> {
    return this._http.post(`${this.baseURL}api/payments`, pay, {
      responseType: 'text' as 'json'
    });
  }

  createPkgActivation(pkg: any): Observable<any> {
    return this._http.post(`${this.baseURL}api/pkgactivations`, pkg, {
      responseType: 'text' as 'json'
    });
  }

  getCustomers(): Observable<any> {
    return this._http.get(`${this.baseURL}api/customers/all`);
  }

  getCustomer(accNo: any): Observable<any> {
    return this._http.get(`${this.baseURL}api/customers/${accNo}`);
  }

  getPkgActivations(accNo: any): Observable<any> {
    return this._http.get(`${this.baseURL}api/pkgactivations/${accNo}/all`);
  }

  getPayments(accNo: any): Observable<any> {
    return this._http.get(`${this.baseURL}api/payments/${accNo}/all`);
  }

  updateCustomer(cust: any): Observable<any> {
    return this._http.put(`${this.baseURL}api/customers/${cust.accNo}`, cust, {
      responseType: 'text' as 'json'
    });
  }

  deleteCustomer(accNo: any): Observable<any> {
    return this._http.delete(`${this.baseURL}api/customers/${accNo}`, {
      responseType: 'text' as 'json'
    });
  }

  deactivatePkgActivations(refNo: any): Observable<any> {
    return this._http.put(`${this.baseURL}api/pkgactivations/${refNo}`,null, {
      responseType: 'text' as 'json'
    });
  }
}
