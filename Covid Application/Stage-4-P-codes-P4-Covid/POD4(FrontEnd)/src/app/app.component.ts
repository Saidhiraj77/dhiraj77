import { Component } from '@angular/core';

import { PacUserService } from './pac-user.service';
import { Pacuser } from './pacuser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Demo1';
  userName = ""
  loggedIn:boolean = false
  constructor(public service: PacUserService){}
  ngOnInit(): void {
    if(this.service.getUserName() == ""){
      this.service.setLoggedIn(false)
    }
    else{
      this.service.setLoggedIn(true)
    }
    
   // console.log(this.service.getSampleData())
    //console.log(this.service.getVCentersData())
  }
  loggingOut(){
    this.service.setUserName("")
    this.service.setLoggedIn(false)
  }
}
