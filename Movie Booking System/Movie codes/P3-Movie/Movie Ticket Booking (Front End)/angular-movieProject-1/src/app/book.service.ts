import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  url:string='http://localhost:8080/book';
  constructor(private http:HttpClient) { }

  bookTicket(book:any)
  {
                                                                    // alert( "Book Service create "+JSON.stringify(book))
    return this.http.post(this.url,book);

  }
  getAllBooks()
  {
    return this.http.get(this.url);
  }
  findbookById(id:any)
  {
    return this.http.get(this.url+"/"+id);
  }
  findbooksByCustomer(id:any)
  {
    return this.http.get(this.url+"/customer/"+id);
  }
  modifyBook(book:any)
  {
    return this.http.put(this.url,book);
  }
  removeBook(id:any)
  {
    return this.http.delete(this.url+'/'+id);
  }

  getBookingId(){
    return this.http.get(this.url+"/booking/bid");
  }
}
