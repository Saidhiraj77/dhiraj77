import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Book } from './book';

@Injectable({
  providedIn: 'root'
})
export class PayBookService {
  book1:any;
  bookTicket(book: Book) {
    this.book1 = new Book();
    this.book1.id = book.id; 
    this.book1.bookDate = book.bookDate;
    this.book1.theatreId = book.theatreId;
    this.book1.movieId = book.movieId;
    this.book1.customerId = book.customerId;
    this.book1.tickets = book.tickets;
    this.book1.seatType = book.seatType;
    this.fnBook()
  }
 
  fnBook(){
    return this.book1;
  }
  constructor() { }
}
