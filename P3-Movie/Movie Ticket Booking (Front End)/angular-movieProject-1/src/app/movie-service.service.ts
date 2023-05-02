import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MovieServiceService {

  url:string='http://localhost:8081/movie';
  constructor(private http:HttpClient) { }

  dummy()
  {
    return this.http.get("http://localhost:8081");
  }
  
  getAllMovie()
  {
                                                              // alert("get movies of servie");
                                                             // alert(JSON.stringify(this.http.get(this.url)))
    return this.http.get(this.url);
  }
  findMovieById(id:any)
  {
    return this.http.get(this.url+"/"+id);
  }
  addMovie(movie:any)                                           //this is not object of movie. this is object of form data
  {
    return this.http.post(this.url,movie);
  }
  modifyMovie(movie:any)
  {
    return this.http.put(this.url,movie);
  }
  removeMovie(id:any)
  {
    return this.http.delete(this.url+"/"+id);
  }

}
