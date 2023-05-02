import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { ManageUsersService } from '../manage-users.service';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-manage-users',
  templateUrl: './manage-users.component.html',
  styleUrls: ['./manage-users.component.css']
})
export class ManageUsersComponent implements OnInit {

  signupForm:any;
  userDetails:any;
  status=false;
  constructor(private fb:FormBuilder, private mus: ManageUsersService, private us:  UserService ) {
    this.signupForm=this.fb.group({
      userId:['',[Validators.required]],
      username:['',[Validators.required,  Validators.minLength(5), Validators.maxLength(10)]],
      password:['',[Validators.required, Validators.minLength(5), Validators.maxLength(10)]],
      role:['',[Validators.required]],
      gender:[''],
      email:['',[Validators.required, Validators.email]],
      phone:['',[Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]]
    });
   }

  ngOnInit(): void {
    this.us.getAllUsers().subscribe((data)=>{
      console.log(data);
      this.userDetails = data;
    })
  }
  fnSelect(u:any){
    this.us.getUserById(u.userId).subscribe((data)=>{
      this.signupForm.patchValue(data); 
  });
}

  fnAdd(){
    this.status=true;
    var muser=new MyUser();

    muser.userId=this.signupForm.controls['userId'].value;
    muser.username=this.signupForm.controls['username'].value;
    muser.password=this.signupForm.controls['password'].value;
    muser.role=this.signupForm.controls['role'].value;
    muser.gender = this.signupForm.controls['gender'].value;
    muser.email = this.signupForm.controls['email'].value;
    muser.phone = this.signupForm.controls['phone'].value;
                                                                                                   // alert("fn ADD " +JSON.stringify(movie));
    this.mus.addUser(muser).subscribe(data=>console.log(data));
  }

  fnModify(){
    this.status=true;

    var muser=new MyUser();

    muser.userId=this.signupForm.controls['userId'].value;
    muser.username=this.signupForm.controls['username'].value;
    muser.password=this.signupForm.controls['password'].value;
    muser.role=this.signupForm.controls['role'].value;
    muser.gender = this.signupForm.controls['gender'].value;
    muser.email = this.signupForm.controls['email'].value;
    muser.phone = this.signupForm.controls['phone'].value;
    this.mus.modifyUser(muser).subscribe(data=>console.log(data));
  }

  fnDelete(){
    this.status=true;

    var muser=new MyUser();
    muser.username=this.signupForm.controls['username'].value;
    this.mus.removeUser(muser.username).subscribe(data=>console.log(data));
  }
}
