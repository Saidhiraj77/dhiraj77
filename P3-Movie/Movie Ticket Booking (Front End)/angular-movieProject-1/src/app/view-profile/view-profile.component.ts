import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-view-profile',
  templateUrl: './view-profile.component.html',
  styleUrls: ['./view-profile.component.css']
})
export class ViewProfileComponent implements OnInit {

 userDetails1=new MyUser();
 userForm:any;
 loggedUser:any;
 status=false;
 statusInfo=false;
  constructor(private us: UserService, private fb: FormBuilder) {
    this.userForm=this.fb.group({
      userId:[''],
      username:[''],
      email:[''],
      phone:[''],
      gender:['']
    });
   }

  ngOnInit(): void {

    var userDetails = localStorage.getItem("user");
    if(userDetails){
      this.userDetails1 = JSON.parse(userDetails);
      this.loggedUser = this.userDetails1.userId;
                                                                                                            // alert(this.userDetails1.userId);
    }
  }
  fnEdit(){
                                                                                                            // alert(this.userDetails1.userId);
    this.us.getUserById(this.loggedUser).subscribe((data)=>{
      this.userForm.patchValue(data); 
      console.log(data); 
      this.status=true;                     
      });
  }

  fnModify(){
    this.statusInfo=true;
    var user =  new MyUser();
    user.userId =this.userForm.controls['userId'].value;
    user.username =this.userForm.controls['username'].value;
    user.email =this.userForm.controls['email'].value;
    user.phone =this.userForm.controls['phone'].value;
    user.gender =this.userForm.controls['gender'].value;
     this.us.modifyUser(user).subscribe(data=>console.log(data));
  }
   
}
