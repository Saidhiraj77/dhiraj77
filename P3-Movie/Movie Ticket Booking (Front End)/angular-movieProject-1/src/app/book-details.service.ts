import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookDetailsService {

 
  // customer_id:any;
  // url:string='http://localhost:8080/mybookings';
  // constructor(private http:HttpClient) { 
  //   var str=localStorage.getItem('user');
  //   if(str!=null){
  //   var user=JSON.parse(str);
  //   alert(JSON.stringify(user));
  //   this.customer_id=user.userId;
  // }
  url:string='http://localhost:8080/mybookings';
  url1:string='http://localhost:8080/book/customer';
  constructor(private http:HttpClient) { }

    
  getAllMyBookings(id:any) {
    return this.http.get(this.url+"/"+id);
  }
   
  findBooksByCustomer(id:any){
    return this.http.get(this.url1+"/" + id);

  }

  getBookingCount(){
    return this.http.get(this.url);
  }
}

// getAllMyBookings() {
//   alert("book details service method "+JSON.stringify(this.customer_id));

//   return this.http.get(this.url,this.customer_id);;
// }
//}
