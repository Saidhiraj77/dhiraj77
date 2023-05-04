import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url: string = 'http://localhost:8080/user';

  constructor(private http: HttpClient) { }
  
  
  GetDetailsById(id: any) {
    return this.http.get(this.url + "/" + id);
  }

  changePassword(user:any)
  {
    return this.http.put(this.url+"/password",user);
  }

  delete(id: any) {
    return this.http.delete(this.url + "/" + id);
  }

  login(id: any, password: string) {
    return this.http.get(this.url + "/" + id + "/" + password);
  }

  Getdetails() {
    return this.http.get(this.url);
  }

  signup(myuser: any) {
    return this.http.post(this.url, myuser);
  }

  loginStatus() {
    var user = localStorage.getItem("user");
    const myObservable = new Observable(observer => {
      setTimeout(() => {
        observer.next(user);
      }, 100);
    });
    return myObservable;
  }
}
