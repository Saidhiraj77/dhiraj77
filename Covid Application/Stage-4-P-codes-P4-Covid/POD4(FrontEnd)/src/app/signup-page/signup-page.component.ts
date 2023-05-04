import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PacUserService } from '../pac-user.service';
import { Pacuser } from '../pacuser';

@Component({
  selector: 'app-signup-page',
  templateUrl: './signup-page.component.html',
  styleUrls: ['./signup-page.component.css']
})
export class SignupPageComponent implements OnInit {
  invalidLogin:boolean = false;
  nextPage:boolean = false
  firstName:string =''
  lastName:string =''
  userName:string =''
  email:string = ''
  gender:string = ''
  age:number = 0
  password:string = ''
  confirmPassword:string = ''
  //pacuser=new Pacuser();
  
  
  // pacuser : any;//Pacuser  = new Pacuser("","","","","",0,"");
  pacuser:Pacuser=new Pacuser();
  message : any;
  emailFlag: boolean = false;
 //e emailFlag: boolean;
  constructor(private router: Router, private service: PacUserService) { }

  ngOnInit() {
  }
  nextpage(){
    console.log("sample text")
    if(this.pacuser.firstName != "" && this.pacuser.lastName != "" && this.pacuser.age >= 18 && this.pacuser.email != "" && this.pacuser.gender != ""){
      this.nextPage = !this.nextPage
      this.invalidLogin = false
      
    }
    else{
      this.invalidLogin = true
    }

  }
  backPage(){
    this.nextPage = !this.nextPage
  }
  public signUp(){
    if(this.pacuser.userName != "" && this.pacuser.password !="" && this.pacuser.password == this.confirmPassword){
      
      this.invalidLogin = false
      let reponse = this.service.doSignupdata(this.pacuser);
      reponse.subscribe(data => {
        this.message = data;
      });
      this.router.navigate(['home']);
    }
    else{
      this.invalidLogin = true
    }
   // emailFlag:Boolean
   //emailFlag=false;
    
     

  }
  }



