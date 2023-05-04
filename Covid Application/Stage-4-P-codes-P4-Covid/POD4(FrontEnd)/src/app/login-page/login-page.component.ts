import { Component, OnInit } from '@angular/core';
import { UrlSegment } from '@angular/router';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { AppComponent } from '../app.component';
import { PacUserService } from '../pac-user.service';
import { Pacuser } from '../pacuser';
@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  pacuser=new Pacuser();
  invalidLogin:boolean = false;

  constructor(private router: Router,public appComp: AppComponent, public service: PacUserService) { }

  ngOnInit(): void {
  }
  validate(typeOfLogin:any){

   if(typeOfLogin=="user") {
    this.service.loginPacuserFromRemote(this.pacuser).subscribe(
    data =>{
    console.log('response')
    this.invalidLogin = false
    this.service.setUserName(this.pacuser.userName)
    this.service.setLoggedIn(true)
 
   this.router.navigate(['../userPage']);
        },
      
        error =>{console.log("exception")
        this.invalidLogin = true
      }
)
    }
    if(typeOfLogin=="admin")
  
    {
      if(this.pacuser.userName=="kranthi@admin" && this.pacuser.password=="kumar") {
        this.service.setUserName(this.pacuser.userName)
    this.service.setLoggedIn(true)
    this.invalidLogin = false
      this.router.navigate(['../adminPage']);
      }
      else{
        this.invalidLogin = true
      }
    }
          }
   openSignUp(){
    this.router.navigate(['../signup'])
          }
}
    

 