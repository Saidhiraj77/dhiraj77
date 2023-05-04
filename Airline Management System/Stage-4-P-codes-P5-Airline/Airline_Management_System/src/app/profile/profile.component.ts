import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  profileForm: any;
  userdata: any;
  valid=false;
  constructor(private fb: FormBuilder, private us: UserService) {
    this.profileForm = this.fb.group({
      id:[],
      username: [],
      password: [],
      email: [],
      pnumber: [],
      gender: []
    });
  }

  fnEditProfile() {
    
    this.us.changePassword(this.profileForm.value).subscribe(data => {
      console.log(data)
      if(data==1)
      {
        this.valid=true;
      }

    });
  }


  ngOnInit(): void {
    this.us.GetDetailsById(localStorage.getItem("userid")).subscribe(data => {
      console.log(data)
      this.userdata = data;
      this.profileForm.patchValue(data);
    });

  }

}
