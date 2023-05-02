import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { Theatre } from '../theatre';
import { TheatreService } from '../theatre.service';

@Component({
  selector: 'app-search-movies',
  templateUrl: './search-movies.component.html',
  styleUrls: ['./search-movies.component.css']
})
export class SearchMoviesComponent implements OnInit , DoCheck {
  movies:any;
  name:any;
  status:any;
  loginStatus:any;
  movieobj: Movie = new Movie();
  theatres:any;
  alltheatrs:any;
  constructor(private ms: MovieService, private ts: TheatreService, private router:Router) { }
  ngDoCheck(): void {
    
  }
  ngOnInit(): void {
    this.ts.getAllTheatre().subscribe((data)=>{
      console.log(data);
      this.theatres=data; 
                                                                                                            //  alert(JSON.stringify(this.theatres).includes( JSON.stringify(localStorage.getItem("search"))));
      if(JSON.stringify(this.theatres).includes( JSON.stringify(localStorage.getItem("search")))){
                                                                                                            // alert("if")
       this.ms.getMovieByTheatreName(localStorage.getItem("search")).subscribe((data)=>{
        console.log(data);
        this.movies=data; 
        console.log(this.movies);   
       });
      }
      else{
                                                                                                             //alert("else");
         this.ms.getMovieByName(localStorage.getItem("search")).subscribe((data)=>{
          console.log(data);
          this.movies=data; 
          console.log(this.movies);   
         });
      }
     });
  }
  fnSearchBook(){
                                                                                                          //   alert("Please Login to book the movie")
  if(localStorage.getItem("user")==null){
     this.status=true;
  }else{
    this.status=false;
    this.router.navigate(['/booking']);

  }

  }

}
