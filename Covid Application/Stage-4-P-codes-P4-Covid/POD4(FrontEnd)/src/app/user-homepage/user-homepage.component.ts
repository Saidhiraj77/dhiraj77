import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Serializer } from 'v8';
import { PacUserService } from '../pac-user.service';
import { Slots } from '../slots';
import { Vcenters } from '../vcenters';
import { Pacuser } from '../pacuser';

@Component({
  selector: 'app-user-homepage',
  templateUrl: './user-homepage.component.html',
  styleUrls: ['./user-homepage.component.css']
})
export class UserHomepageComponent implements OnInit {
  userTable:boolean = false;
  vCenters:boolean = false
  bookSlot:boolean = false
  helpInfo:boolean = false
  showVCenter:boolean = false
  help:boolean = false
  profile:boolean = false
  pinCode:number=0
  slotDate: Date | undefined
  slotTime: string=''
  vType: string=''
  vCentersData:any =[]
  bookData :any = {}
  vcenters:Vcenters= new Vcenters();
  slots:Slots= new Slots();
  message : any;
  bookingData: any=[];
  //pacuser: any;
  pacuser=new Pacuser();
  userData: any=[];
  //profile: boolean;
  //help: boolean;
  constructor(private router: Router,public service: PacUserService) { }

  ngOnInit() {
    
  }

  onBtnClick(value:string){
    if(value == "showVCenter"){
      this.userTable = false
      this.showVCenter = true
      this.bookSlot = false
      this.profile = false
      this.help = false
    }
    else if(value == "userTable"){
      this.userTable = true
      this.showVCenter = false
      this.bookSlot = false
      this.profile = false
      this.help = false
    }
    else if(value == "profile"){
      this.userTable = false
      this.showVCenter = false
      this.bookSlot = false
      this.profile = true
      this.help = false
    }
    else if(value == "help"){
      this.userTable = false
      this.showVCenter = false
      this.bookSlot = false
      this.profile = false
      this.help = true
    }
    else{
      this.slots.centerName= value
      this.userTable = false
      this.showVCenter = false
      this.bookSlot = true
    }
    
  }
  public getBookingDatabyUsername(){
    
   var name=this.service.getUserName();
   console.log("name");
   console.log("hiii");
    let response1 = this.service.getBookingDatabyUsername(name);
     response1.subscribe(data => this.bookData = data);
     
     alert("hello...  "  +name)
    
  }
 public generatePdfbyUserName(){
   //var nik= this.pacuser.userName;
   //console.log(nik)
 
var userName1=this.service.getUserName();
 //alert(userName1)
 // console.log(userName1);
   console.log("Downloading pdf");
   let response1 = this.service.getPdfbyUserName(userName1);
 window.location.href="http://localhost:8084/users/export/pdf/"+userName1;
 }

 public getUserDatabyId(){
  var uname=this.service.getUserName();
  let response1 = this.service.getUserDatabyId(uname);
  response1.subscribe(data => this.userData = data);
   
   alert("hello...  " +uname)
  
}


   public findVcentersByPinCode(){
   let response = this.service.getVcentersByPinCode(this.vcenters.pinCode);
   response.subscribe(data => this.vCentersData = data);
  }

public getBookingData(){
  let response2=this.service.getBookingData();
  response2.subscribe(data=>this.bookingData=data)
}
  public confirmSlot(){
    
    console.log(this.slots)
    this.slots.userName= this.service.getUserName();
    
    let reponse = this.service.doSlotBook(this.slots);
      reponse.subscribe(data => {
        this.message=data
        alert("You have successfully registered for vaccine slot")
      },
error => { alert("You have already booked vaccine slot")}

      )
  }

}
