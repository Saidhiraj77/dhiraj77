import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TheatreService {

  url:string='http://localhost:8080/theatre';
  
  constructor(private http:HttpClient) { }
  
  addTheatre(theatre:any)
  {
                                                                                          // alert("movie service "+JSON.stringify(theatre));
    return this.http.post(this.url,theatre);
  }

  getAllTheatre(){
    return this.http.get(this.url);
  }

  modifyTheatre(theatre:any)
  {
    return this.http.put(this.url,theatre);
  }
  removeTheatre(id:any)
  {
                                                                                          //alert("theatre service  remove theatre "+JSON.stringify(id));
    return this.http.delete(this.url+"/"+id);
  }

  findTheatreById(id:any){
    return this.http.get(this.url+"/"+id);
  }
  
}
