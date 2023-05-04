import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Book } from '../book';
import { BookDetailsService } from '../book-details.service';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  myBookings:any;
  customer_id:any;
  str=localStorage.getItem('user');

  constructor(private fb:FormBuilder, private mbs: BookDetailsService) { 
    
  }
 
  ngOnInit(): void {
    if(this.str!=null){
    var user=JSON.parse(this.str); 
                                                                                          // alert("Init method "+ JSON.stringify(user));
    this.customer_id=user.userId;
                                                                    
    this.mbs.findBooksByCustomer(this.customer_id).subscribe((data:any)=>
    {
      console.log(data);
      this.myBookings=data;
                                                                                           // alert("Init method get All "+ JSON.stringify(this.myBookings));
    })
    
    }
  }

}



