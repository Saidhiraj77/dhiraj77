import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SeatsService {

  url:string='http://localhost:8080/seats';
  constructor(private http:HttpClient) { }
   
   getAllSeats(){
     return this.http.get(this.url);
   }

   getSeatsById(id:number){
    return this.http.get(this.url+"/"+ id);

   }
   addSeats(seats:any){
    alert(JSON.stringify(seats));

    return this.http.post(this.url,seats);

   }
   updateSeats(seats:any){
    return this.http.put(this.url,seats);
   }
  removeSeats(id:number){
    return this.http.delete(this.url + "/" + id);

  }}
