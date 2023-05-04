import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Theatre } from '../theatre';
import { TheatreService } from '../theatre.service';

@Component({
  selector: 'app-theatre',
  templateUrl: './theatre.component.html',
  styleUrls: ['./theatre.component.css']
})
export class TheatreComponent implements OnInit {

 
  adminTheatreForm:any;
  theatres:any;
  status=false;
   constructor(private fb: FormBuilder, private ts: TheatreService) { 
     this.adminTheatreForm=this.fb.group({
       theatreId:['',[Validators.required]],
       theatreName:['',[Validators.required]]
     });
   }
  ngOnInit(): void {
    this.ts.getAllTheatre().subscribe((data)=>{
      console.log(data);
      this.theatres=data;                                  
     })
  }
  fnSelect(t:any){
    this.ts.findTheatreById(t.theatreId).subscribe((data)=>{
      this.adminTheatreForm.patchValue(data); 
  });
}
  fnAdd(){
    var theatre = new Theatre();
    this.status=true;

    theatre.theatreId=this.adminTheatreForm.controls['theatreId'].value;
    theatre.theatreName=this.adminTheatreForm.controls['theatreName'].value;
                                                                                               // alert("add theatre id & name " +JSON.stringify(theatre));
    this.ts.addTheatre(theatre).subscribe(data=>console.log(data));
  }
  fnModify(){
    this.status=true;
    var theatre = new Theatre();
    theatre.theatreId=this.adminTheatreForm.controls['theatreId'].value;
    theatre.theatreName=this.adminTheatreForm.controls['theatreName'].value;
                                                                                              // alert("modify theatre id & name " +JSON.stringify(theatre));
    this.ts.modifyTheatre(theatre).subscribe(data=>console.log(data));
  }

  fnDelete(){
    this.status=true;
    var theatre = new Theatre();
    theatre.theatreId=this.adminTheatreForm.controls['theatreId'].value;
    theatre.theatreName=this.adminTheatreForm.controls['theatreName'].value;
                                                                                                // alert("remove theatre id & name " +JSON.stringify(theatre));
    this.ts.removeTheatre(theatre.theatreId).subscribe(data=>console.log(data));

  }
}
