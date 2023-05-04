import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PacUserService } from '../pac-user.service';
import { TestObject } from 'protractor/built/driverProviders';
import { Vcenters } from '../vcenters';
import { Pacuser } from '../pacuser';

@Component({
  selector: 'app-admin-homepage',
  templateUrl: './admin-homepage.component.html',
  styleUrls: ['./admin-homepage.component.css']
})
export class AdminHomepageComponent implements OnInit {
  invalidCenter:boolean = false;
  invalidUser:boolean = false;
  vCenters:boolean = false
  addVCenter:boolean = false
  editVCenter:boolean = false
  userTable:boolean = false
  centersPage:boolean = false
  editcentersPage:boolean = false
  editusersPage:boolean = false
  editUser:boolean = false
  sampleData: any
  vCentersData: any
  id: number=0
  name: string=''
  pinCode: number=0
  

  vcenters:Vcenters=new Vcenters();
  pacuser:Pacuser=new Pacuser();
  message: any;
  vcentersdata: any=[];

  constructor(private router: Router,private service: PacUserService) { }

  ngOnInit() {
    
  }
  

  public removePacuser(id : number){
    let response = this.service.deletePacuser(id);
    response.subscribe(data => this.sampleData = data);
    let response1 = this.service.getSampleData();
    response1.subscribe(data => this.sampleData = data);
  }

  public removeVcenters(id : number){
    let response = this.service.deleteVcenters(id);
    response.subscribe(data => this.sampleData = data);
     //let response2 = this.service.getVCentersData();
    //response2.subscribe(vdata => this.vCentersData = vdata);
  }

  onBtnClick(value:string){
    if(value == "user"){
      let response1 = this.service.getSampleData();
    response1.subscribe(data => this.sampleData = data);
      this.userTable = true
      this.vCenters = false
      this.addVCenter = false
      this.editVCenter = false
      this.editUser = false
    }
    else if(value == "vCenters"){
      let response2 = this.service.getVCentersData();
    response2.subscribe(vdata => this.vCentersData = vdata);
      this.vCenters = true
      this.userTable = false
      this.addVCenter = false
      this.editVCenter = false
      this.editUser = false

    }
    else if(value == "addVCenter"){
      this.addVCenter = true
      this.vCenters = false
      this.userTable = false
      this.editVCenter = false
      this.editUser = false
    }
    else if(value == "editVCenter"){
      this.addVCenter = false
      this.vCenters = false
      this.userTable = false
      this.editVCenter = true
      this.editUser = false
    }
    else if(value == "editUser"){
      this.addVCenter = false
      this.vCenters = false
      this.userTable = false
      this.editVCenter = false
      this.editUser = true
    }
  }

 public centerspage(){
   if(this.vcenters.id >= 1 && this.vcenters.name != "" && this.vcenters.pinCode >= 500000){
    this.centersPage = !this.centersPage
    this.invalidCenter = false
    let reponse = this.service.doCentersdata(this.vcenters);
      reponse.subscribe(data => {
        this.message = data;
        this.vcentersdata=data;
        alert("You have successfully added new vaccination center")
      },
      error =>{
        alert("Add only new vaccination centers with new id")
      }
      
      
      );
      
    let response2 = this.service.getVCentersData();
    response2.subscribe(vdata => this.vCentersData = vdata);
  }
  else{
    this.invalidCenter = true
  }
  //let reponse = this.service.doCentersdata(this.vcenters);
    //  reponse.subscribe(data => {
     //   this.message = data;
     // });
      
   // let response2 = this.service.getVCentersData();
   // response2.subscribe(vdata => this.vCentersData = vdata);
    
}
//public displayVcen
public editcenterspage(){
  if(this.vcenters.id >= 1 && this.vcenters.name != "" && this.vcenters.pinCode >= 500000){
   this.editcentersPage = !this.editcentersPage
   this.invalidCenter = false
alert("Vaccination center details are updated")
 }
 else{
   this.invalidCenter = true
 }
 let reponse = this.service.editCentersdata(this.vcenters);
     reponse.subscribe(data => {
       this.message = data;

     });
}

public edituserspage(){
  if(this.pacuser.id >= 1 && this.pacuser.firstName != "" && this.pacuser.lastName != "" && this.pacuser.age >= 15 && this.pacuser.email != "" && this.pacuser.gender != "" && this.pacuser.userName != ""){
   this.editusersPage = !this.editusersPage
   this.invalidUser = false
 }
  else{
   this.invalidUser = true
 }
 let reponse = this.service.editUsersdata(this.pacuser);
     reponse.subscribe(data => {
       this.message = data;
     });
}
  
}

