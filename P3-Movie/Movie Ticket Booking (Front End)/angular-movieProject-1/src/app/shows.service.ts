import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ShowsService {

  url:string='http://localhost:8080/shows';
  constructor(private http:HttpClient) { }
   
   getAllShows(){
     return this.http.get(this.url);
   }

   getShowsById(id:number){
    return this.http.get(this.url+"/"+ id);

   }
   addShows(shows:any){
    alert(JSON.stringify(shows));

    return this.http.post(this.url,shows);

   }
   updateShows(shows:any){
    return this.http.put(this.url,shows);
   }
  removeShows(id:number){
    return this.http.delete(this.url + "/" + id);

  }
}
