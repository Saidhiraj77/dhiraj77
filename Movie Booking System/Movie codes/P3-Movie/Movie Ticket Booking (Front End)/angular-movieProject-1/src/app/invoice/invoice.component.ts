import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Book } from '../book';
import { BookService } from '../book.service';
import { PayBookService } from '../pay-book.service';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  
  book: Book = new Book;
  bookimage:any;
  bookTheatreName:any;
  bookMovieName:any;
  bookObj:any;
  bookingId:any;
  bookDate:any;
  showName:any;
  constructor( private ps: PayBookService, private bs: BookService ) { }

  ngOnInit(): void {
    this.book = this.ps.fnBook();
                                                                                                  // alert(JSON.stringify(this.book))
    this.bookimage=localStorage.getItem("bookimage");
    this.bookMovieName=localStorage.getItem("movieName");
    this.bookTheatreName=localStorage.getItem("theatreName");
    this.bs.getBookingId().subscribe((data)=>{
      console.log(data);
      this.bookObj = data;
      this.bookingId = this.bookObj.id;
                                                                                                    // alert(JSON.stringify(this.bookObj));
                                                                                                     // alert(JSON.stringify(this.bookingId));
      this.bookDate = localStorage.getItem("bookDate");
      this.showName = localStorage.getItem("showName");

    });
  }

}
