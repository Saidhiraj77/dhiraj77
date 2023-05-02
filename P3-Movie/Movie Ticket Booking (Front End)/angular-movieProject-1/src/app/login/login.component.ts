import { Component, OnInit } from '@angular/core';
import { FormBuilder ,FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MovieService } from '../movie.service';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:any;
  users:any;
  admin:any;
  role:any;
  statusCred=false;
  // userstatus:any;
  constructor(private fb:FormBuilder, private us:UserService, private router:Router, private ms: MovieService) { 
    this.loginForm=this.fb.group({
      username:['', [Validators.required]],
      password:['', [Validators.required]],
      admin:[],
      role:[]
    });

  }
  signStatus:any;
  ngOnInit(): void {
    this.us.getAllUsers().subscribe((data)=>{
      console.log(data);
      this.users=data;                                  
     });
    }
 
  login()
  {
                                                                                                               // alert(this.statusCred);
    var admin = this.loginForm.controls['admin'].value;
    var role = "user";
    var username=this.loginForm.controls['username'].value;
    var password=this.loginForm.controls['password'].value;
    this.signStatus = true;
    this.us.login(username,password,role).subscribe((data)=>{
      console.log(data)

      //login failed/success what to do all  these logics to be written inside this lamdba 
      //i am going to notify menu component now
      this.us.loginStatus();
      if(data!=null)
      {
        var user:any;
        var role =  new MyUser;
        user=data;
                                                                                                               // alert(user);

        localStorage.setItem("user",JSON.stringify(user));
        this.us.loginStatus().subscribe();
        var role1 = localStorage.getItem('user');
          if(role1){
            role = JSON.parse(role1);
          }
           
        if(role.role=="user") {
          this.router.navigate(['/homeUser']);  
        }
        else{
          this.router.navigate(['/home']);
        }
      }else{

        localStorage.setItem("user",JSON.stringify(null));
  
      }
    });
    //not here
  } 

  

}
function mov(mov: any) {
  throw new Error('Function not implemented.');
}

