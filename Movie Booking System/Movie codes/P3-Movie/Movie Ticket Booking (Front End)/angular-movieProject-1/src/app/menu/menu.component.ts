import { Component, DoCheck, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, DoCheck, OnChanges {
  status:string="login";
  role:any;
  statussignup:any ;
  signupnave:any;
  userName:any;
  movies:any;
  searchmovie:any;
  bid:string="" ;                                                  

  constructor(private us:UserService, private ar:ActivatedRoute, private router:Router , private ms : MovieService) { }
  ngOnChanges(changes: SimpleChanges): void {
    throw new Error('Method not implemented.');
  }
  ngDoCheck(): void {                                                                                     // console.log("ngDoCheck started");
    this.us.loginStatus().subscribe((data)=>{
                                                                                                          // console.log(data);
      if(data==null)
        this.status="login";
      else
      {
        this.status="logout";
        
      }      
    });
                                                                                                          // alert(" statusignup "+ this.statussignup);          
                                                                                                           // console.log("ngDoCheck ends");
     var role =  new MyUser;
     var role1 = localStorage.getItem('user');
  
      if(localStorage.getItem('user') == null){
        this.signupnave = true;
      }else{
          this.signupnave = false;
      } 
      var roleName =  new MyUser;
      var role1= localStorage.getItem("user");

      if(role1){
        roleName = JSON.parse(role1);
      }

      this.userName = roleName.username;
  }

  ngOnInit(): void {
                                                                                                          //check the login status and update the this.status value

  }
   
  fnSearch(){

                                                                                                          //  alert("MENU " + this.bid);
      localStorage.setItem("search",this.bid);
     this.router.navigate(['/searchMovies']);
 
  }
}
