import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private us: UserService) { }

  ngOnInit(): void {
    localStorage.removeItem("user");
    localStorage.removeItem("username");
    localStorage.removeItem("role");
    localStorage.removeItem("userid");
    localStorage.removeItem("flight");
    localStorage.removeItem("payment");
    localStorage.removeItem("password");
    this.us.loginStatus();


  }

}
