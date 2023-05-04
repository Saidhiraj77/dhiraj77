import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url:string='http://localhost:8080/user';
  
  constructor(private http:HttpClient) { }

  dummy()
  {
    return this.http.get("http://localhost:8080");
  }

  getAllUsers(){
    return this.http.get(this.url);
  }

  login(username:string, password:string, role:string)
  {
    return this.http.get(this.url+"/"+username+"/"+password + "/" + role);
  }

  modifyUser(myuser:any){
    return this.http.put(this.url,myuser);
  }

  getUserById(id:any){
    return this.http.get(this.url+"/"+id);
  }

  signup(myuser:any)
  {
    return this.http.post(this.url,myuser);
  }

  getUserCount(){
    return this.http.get(this.url+"/count");
  }

  loginStatus()
  {
    var user=localStorage.getItem("user");
  
    const myObservable=new Observable(observer=>{
      setTimeout(()=>{
         
        observer.next(user);
      },100);
    });
    return myObservable;
  }
  getOtp(email:string)
  {
    return this.http.get(this.url+"/otp/"+email);
  }
}
