import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AddflightService {
url:string="http://localhost:8080/flight"
  constructor(private ht:HttpClient) {
   }

   GetAllDetails()
   {
     return this.ht.get(this.url);
   }

   GetDetailsById(id:any)
   {
     return this.ht.get(this.url+"/"+id);
   }

  addFlightDetails(flight:any)
  {
    return this.ht.post(this.url,flight);
  }
  modifyFlightDetails(flight:any)
  {
    return this.ht.put(this.url,flight);
  }
  deleteFlightDetails(id:any)
  {
    return this.ht.delete(this.url+"/"+id);
  }
}
