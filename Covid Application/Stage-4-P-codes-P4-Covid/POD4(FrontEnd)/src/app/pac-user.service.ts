import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pacuser } from './pacuser';
import { Vcenters } from './vcenters';
import { Observable } from 'rxjs';
import { Slots } from './slots';

@Injectable({
  providedIn: 'root'
})
export class PacUserService {
  private userName: string = "";
  private loggedIn: boolean = false;
  
  constructor(private httpclient: HttpClient) { }
  getUserName() {
    return this.userName;
  }
  setUserName(userName: string) {
    this.userName = userName
  }
  getLoggedIn() {
    return this.loggedIn;
  }
  setLoggedIn(loggedIn: boolean) {
    this.loggedIn = loggedIn
  }
  
  public doSignupdata(pacuser:Pacuser){
    return this.httpclient.post("http://localhost:8084/user", pacuser, {responseType : "text" as "json"});
  }

  public editUsersdata(pacuser: Pacuser){
    return this.httpclient.put("http://localhost:8084/user", pacuser, {responseType : "text" as "json"});
  }
  public getUserDatabyId(userName:string){
    return this.httpclient.get("http://localhost:8084/user/"+userName);
  }

  public doCentersdata(vcenters: Vcenters){
    return this.httpclient.post("http://localhost:8084/centers", vcenters, {responseType : "text" as "json"});
  }

  public doSlotBook(slots:Slots){
    return this.httpclient.post("http://localhost:8084/Slots", slots, {responseType : "text" as "json"});
  }
public getBookingData()
{
  return this.httpclient.get("http://localhost:8084/Slots");
}
public getBookingDatabyUsername(userName:string){
  return this.httpclient.get("http://localhost:8084/Slots/"+userName);
}

public getPdfbyUserName(userName:string)
{
  //return this.httpclient.get("http://localhost:8084/users/export/pdf/"+userName,{ responseType: 'arraybuffer' as 'json' });
  return this.httpclient.get("http://localhost:8084/users/export/pdf/"+userName);
}
  public editCentersdata(vcenters: Vcenters){
    return this.httpclient.put("http://localhost:8084/centers", vcenters, {responseType : "text" as "json"});
  
  }

  public getSampleData() {
    return this.httpclient.get("http://localhost:8084/user");
     }
  public  getVCentersData() {
    return this.httpclient.get("http://localhost:8084/centers");
  }   

   public getVcentersByPinCode(pinCode: number){
   return this.httpclient.get("http://localhost:8084/centers/"+pinCode);
   }
  
  public deletePacuser(id: string | number){
    return this.httpclient.delete("http://localhost:8084/user/"+id);
  }

  public deleteVcenters(id: string | number){
    return this.httpclient.delete("http://localhost:8084/centers/"+id);
  }

  public loginPacuserFromRemote(pacuser: Pacuser):Observable<any> {
    return this.httpclient.post<any>("http://localhost:8084/login", pacuser);
}
  // async getSampleData(){
  //   await this.httpclient.get("users")
  //       .toPromise().then(data => {
  //         var vaccineCenters = data
  //         console.log(data)
  //         return vaccineCenters
  //   })
  // }
}
