import { Component, DoCheck, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { UserService } from '../user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, DoCheck {
  loginForm: any;
  str: any;
  role: any;
  username: any;
  user_id: any;
  pass: any;
  valid = true;
  constructor(private fb: FormBuilder, private us: UserService, private router: Router) {
    this.loginForm = this.fb.group({
      id: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  ngOnInit(): void {
  }

  ngDoCheck(): void {
    if ((this.pass == this.loginForm.controls['password'].value) && (this.user_id == this.loginForm.controls['id'].value)) {
      this.valid = false;
    }
    else {
      this.valid = true;
    }
  }


  fnGet() {
    this.us.GetDetailsById(this.loginForm.controls['id'].value).subscribe(data => {
      var user = data;
      this.str = JSON.parse(JSON.stringify(user));
      this.user_id = this.str.id;
      this.pass = this.str.password;
    });
  }

  login() {
    var id = this.loginForm.controls['id'].value;
    var password = this.loginForm.controls['password'].value;
    this.us.login(id, password).subscribe((data) => {
      // console.log(data)
      this.us.loginStatus();
      
      if (data != null) {
        var user = data;
        localStorage.setItem("user", JSON.stringify(user));
        this.us.loginStatus().subscribe();
        this.str = JSON.parse(JSON.stringify(user));
        this.role = this.str.role;
        this.username = this.str.username;
        this.user_id = this.str.id;
        this.pass = this.str.password;
        localStorage.setItem("password",this.pass);
        localStorage.setItem("userid", this.user_id);
        localStorage.setItem("username", this.username);
        localStorage.setItem("role", this.role);

        if (this.role == "admin") {
          this.router.navigate(['/add-flight']);
        }
        else {
          this.router.navigate(['/home']);
        }
      }
      else {
        localStorage.setItem("user", 'null');
        localStorage.setItem("username", 'null');
        localStorage.setItem("role", 'null');
        localStorage.setItem("userid", 'null');
        return;
      }
    });
  }
  get f() {
    return this.loginForm.controls;
  }

}
