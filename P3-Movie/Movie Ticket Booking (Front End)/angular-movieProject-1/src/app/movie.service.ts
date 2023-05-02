import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class MovieService {

  url:string='http://localhost:8080/movie';
  
  constructor(private http:HttpClient) { }


  addMovie(movie:any)
  {
                                                                                     // alert("movie service "+JSON.stringify(movie));
    return this.http.post(this.url,movie);
  }

  getAllMovie(){
    return this.http.get(this.url);
  }

  modifyMovie(movie:any)
  { 
                                                                                 // alert("Modify movie service method "+ JSON.stringify(movie) )
    return this.http.put(this.url,movie);
  }

  modifyMovieticket(movie:any)
  { 
                                                                                 // alert("Modify movie service method "+ JSON.stringify(movie) )
    return this.http.put(this.url+"/tickets",movie);
  }
  modifyMovieWithoutPic(movie:any)
  {
    return this.http.put(this.url +"/withoutpic",movie);
  }
  removeMovie(id:any)
  {
                                                                                 // alert("theatre service  remove theatre "+JSON.stringify(id));
    return this.http.delete(this.url+"/"+id);
  }
	getMovieById(id:any)
	{
		return this.http.get(this.url+"/"+id);;
	}

  getMovieByName(name:any)
	{
		return this.http.get(this.url+"/movie/"+name);
	}
  
  getMovieByTheatreName(tname:any){
		return this.http.get(this.url+"/theatre/"+tname);

  }
  fnSearch(movies:any){
    return movies;
  }
}
