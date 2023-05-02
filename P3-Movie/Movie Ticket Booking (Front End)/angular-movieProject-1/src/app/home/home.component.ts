import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BookDetailsService } from '../book-details.service';
import { MovieServiceService } from '../movie-service.service';
import { UserService } from '../user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  adminMovieForm:any;
  movies:any;
  bookObj:any;
  bookingCount:any;
  userObj:any;
  userCount:any;
  constructor(private fb: FormBuilder, private ms: MovieServiceService, private bs: BookDetailsService, private us: UserService) { 
    this.adminMovieForm=this.fb.group({
      id:[''],
      movieName:[''],
      theatre:['']
    });
  }
  ngOnInit(): void {
                                                                                                       // alert("init method");
    this.ms.getAllMovie().subscribe((data)=>{
      console.log(data);
      this.movies=data;   
     });  
                                                                                                      //  alert(JSON.stringify(this.movies));
      this.bs.getBookingCount().subscribe((data)=>{
      console.log(data);
      this.bookObj=data;  
      this.bookingCount = this.bookObj.id; 
     })     
     
     this.us.getUserCount().subscribe((data)=>{
      console.log(data);
      this.userObj=data;  
      this.userCount = this.userObj.userId; 
     })       
  }
}
