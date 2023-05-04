import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ManageUsersService {

  url:string='http://localhost:8080/user';
  
  constructor(private http:HttpClient) { }


  addUser(muser:any)
  {
    return this.http.post(this.url,muser);
  }

  getAllUsers(){
    return this.http.get(this.url);
  }

  modifyUser(muser:any)
  {
                                                                         // alert("manage service  modify user "+JSON.stringify(muser));
    return this.http.put(this.url,muser);
  }
  removeUser(username:any)
  {
                                                                       // alert("manage service  remove user "+JSON.stringify(username));
    return this.http.delete(this.url+'/'+username);
  }

}
