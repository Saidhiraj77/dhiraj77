import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Book } from '../book';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-seats',
  templateUrl: './seats.component.html',
  styleUrls: ['./seats.component.css']
})
export class SeatsComponent implements OnInit {
  
  id:any; 
  id1: Book = new Book;
  BookForm:any;
  constructor(private fb: FormBuilder, private ms: MovieService) {
    var str = "movie";
    this.BookForm=this.fb.group({
      category:[''],
      tickets:[]
    });
   }
  
  ngOnInit(): void {
    var bookseats = new Book();
    var role1 = localStorage.getItem('confirmBook');
          
    if(role1){
      bookseats = JSON.parse(role1);
      this.id1=bookseats;   
    }
    var a = this.id         
                                                                                                    // alert("seats component "+ JSON.stringify(bookseats));
  }
  fnBook(){
    var noOfTickets=this.BookForm.controls['tickets'].value;
    var AvailableTickets =  10;
    if(noOfTickets<= AvailableTickets){
      var BookedTickets =  noOfTickets;
      var seatType=this.BookForm.controls['category'].value;
    }else{

    }
  }
  fnCancel(){
    
  }
}
