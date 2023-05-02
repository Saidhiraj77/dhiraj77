import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ShowsService } from '../shows.service';

@Component({
  selector: 'app-shows',
  templateUrl: './shows.component.html',
  styleUrls: ['./shows.component.css']
})
export class ShowsComponent implements OnInit {

  adminShowsForm:any;
  shows:any;
  constructor(private fb: FormBuilder, private ss: ShowsService) { 
    this.adminShowsForm=this.fb.group({
       showId:[],
       showName:[],
       showDate:[],
       showTime:[],
       movieId:[],
       theatreId:[],
       noOfTickets:[]
    });
  }

  ngOnInit(): void {
    this.ss.getAllShows().subscribe((data)=>{
      console.log(data);
      this.shows=data; 
    });
  }



fnAdd(){
  console.log(this.adminShowsForm.value);
  alert(JSON.stringify(this.adminShowsForm.value));
  this.ss.addShows(this.adminShowsForm.value).subscribe((data)=>{
    console.log(data);
  });
}
fnModify(){
  console.log(this.adminShowsForm.value);
  alert(JSON.stringify(this.adminShowsForm.value));
  this.ss.updateShows(this.adminShowsForm.value).subscribe((data)=>{
    console.log(data);
  });

}
fnDelete(){
  const showId=this.adminShowsForm.controls['showId'].value;
  this.ss.removeShows(showId).subscribe((data)=>{
    
});
}
}
