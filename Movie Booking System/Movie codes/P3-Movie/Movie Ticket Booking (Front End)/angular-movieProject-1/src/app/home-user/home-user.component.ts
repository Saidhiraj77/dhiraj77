import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.css']
})
export class HomeUserComponent implements OnInit {
  movies:any;

  constructor(private router:Router,private fb:FormBuilder, private ms: MovieService) { }

  ngOnInit(): void {
    this.ms.getAllMovie().subscribe((data)=>{
      console.log(data);
      this.movies=data;                                  
     });
  }
  fnBook(){
  this.router.navigate(['/booking']);
  }
}
