import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  url:string="http://localhost:8080/booking/payment";
  constructor(private http:HttpClient) { }


  GetPayment(classtype:any,count:any)
  {
    return this.http.get(this.url+"/"+classtype+"/"+count);
  }
}
