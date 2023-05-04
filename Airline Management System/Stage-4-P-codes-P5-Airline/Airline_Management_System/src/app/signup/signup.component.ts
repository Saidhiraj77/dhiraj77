import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
 
  signupForm: any;



  
  constructor(private fb: FormBuilder, private us: UserService) {
    this.signupForm = this.fb.group({
      id: [''],
      username: [''],
      password: [''],
      confirmPassword: [''],
      email: [''],
      pnumber: [''],
      dob: [''],
      gender: ['']
    });
  }

  signup() {
    var myuser = this.signupForm.value;
    this.us.signup(myuser).subscribe(data => {
      console.log(data)
      if (data == 1) {
        alert("You have successfully Registered. Please login !!!")
      }
    });
  }


  ngOnInit(): void {
  }

  get f() {
    return this.signupForm.controls;
  }

}
