import { Component, DoCheck, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { iif } from 'rxjs';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  validate: any;
  UserName: any;
  roleBasedDisplay=true;
  status: string = "login";

  constructor(private us: UserService, private ar: ActivatedRoute, private router: Router) { }
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }

  fnChangePassword(){
    this.us.changePassword(localStorage.getItem("user")).subscribe(data=>{
      console.log(data)
    });
  }


  fnDelete() {
    var user = localStorage.getItem("userid");
    this.us.delete(user).subscribe((data) => {
      console.log(data)
      if (data == 1) {
        alert("You have Successfully deleted your account. Please signup again to login")
        localStorage.removeItem("userid")
        this.us.loginStatus();
        this.router.navigate(['/', 'logout']);
      }

    });

  }
  ngDoCheck(): void {
    
    //  Login Logout Status Changes

    this.us.loginStatus().subscribe((data) => {
      if (data == null) {
        this.status = "login";
      }
      else {
        this.status = "logout";

        this.UserName ="Hi! " +localStorage.getItem("username");
      }
    });

   if (localStorage.getItem('role') == "admin") {
      // console.log("Admin login");
      this.roleBasedDisplay=true;
 
    }
    else if (localStorage.getItem('role') == "user")
    {
      // console.log("user login");
      this.roleBasedDisplay=false;
    }
    if (localStorage.getItem("user") == null) {
      this.validate = true;
    }
    else {
      this.validate = false;
    }
  }
  ngOnInit(): void {

  }
}
