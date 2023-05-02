import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { MovieService } from '../movie.service';
import { PayBookService } from '../pay-book.service';

@Component({
  selector: 'app-payment-book',
  templateUrl: './payment-book.component.html',
  styleUrls: ['./payment-book.component.css']
})
export class PaymentBookComponent implements OnInit {

  movies:any;
  book:any;
  price:any;
  bookId=16;
  constructor(private fb:FormBuilder,private bs:BookService,private ms: MovieService, private ps: PayBookService, private router:Router) { 

  }
  
  ngOnInit(): void {
    var str=localStorage.getItem('confirmBook');
   
    if(str!=null){
      var book=JSON.parse(str);
                                                                                                            // alert(book);
                                                                                                            // alert(book.seatType + " " + book.tickets);
      if(book.seatType=="Silver"){
          var calprice= book.tickets * 150;
      }else if(book.seatType=="Gold"){
          var calprice= book.tickets * 300;
      }else{
          var calprice= book.tickets * 500;
      }
        this.price = calprice;
       localStorage.setItem("payAmount",JSON.stringify(this.price));
                                                                                                            //  alert("payamount "+ this.price)
                                                                                                            //  alert(this.bookId);
        this.bookId = ++this.bookId;                
    }
    
  }

  fnConfirm(){
                                                                                                              // alert("fn Confirm")
    this.router.navigate(['/invoice']);
  }


};