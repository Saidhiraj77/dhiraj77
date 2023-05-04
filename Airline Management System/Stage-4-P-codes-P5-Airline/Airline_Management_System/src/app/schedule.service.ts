import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {
 
  url:string='http://localhost:8080/schedule';
 
 
  constructor(private http:HttpClient) { }

  getAllSchedules()
  {
    return this.http.get(this.url);
  }
 
  findScheduleById(id:number)
  {
    return this.http.get(this.url+"/"+id);
  }
 
  findSchedulesBySourceDestinationDate(source:string, destination:string)
  {
    return this.http.get(this.url+"/"+source+"/"+destination);
  }
  
  addSchedule(schedule:any)
  {
    alert(JSON.stringify(schedule));
    return this.http.post(this.url,schedule);
  }


  repeat(schedule:any)
  {
    return this.http.post(this.url+"/repeat",schedule);
  }
  

  modifySchedule(schedule:any)
  {
    return this.http.put(this.url,schedule);
  }
  
  
  removeSchedule(id:number)
  {
    return this.http.delete(this.url+"/"+id);
  }
}
