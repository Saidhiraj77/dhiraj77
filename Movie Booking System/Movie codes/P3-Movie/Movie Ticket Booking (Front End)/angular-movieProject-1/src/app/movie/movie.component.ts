import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { Theatre } from '../theatre';

@Component({
  selector: 'app-movie',
  templateUrl: './movie.component.html',
  styleUrls: ['./movie.component.css']
})
export class MovieComponent implements OnInit {


   adminMovieForm:any;
   movies:any;
   selectedFile:any;                
   status:any;
   constructor(private fb: FormBuilder, private ms: MovieService ) { 
     this.adminMovieForm=this.fb.group({
       movieId:['',[Validators.required]],
       movieName:['',[Validators.required]],
       noOfTickets:['',[Validators.required]],
       theatreId:['',[Validators.required]],
      //  image:['',[Validators.required]]  
       image:['']                      
                    
      });
   }
  ngOnInit(): void {
    this.ms.getAllMovie().subscribe((data)=>{
      console.log(data);
      this.movies=data;                                  
     })
  }
                                       
  onFileChanged(event:any){
           this.selectedFile=event.target.files[0];
           console.log(JSON.stringify(this.selectedFile));
  }
  fnSelect(m:any){
    this.ms.getMovieById(m.movieId).subscribe((data)=>{
      this.adminMovieForm.patchValue(data); 
  });
}

  fnAdd(){
    this.status = true;                
    console.log(this.selectedFile);     
    const x = new FormData;
    x.append('movieId',this.adminMovieForm.controls['movieId'].value);
    x.append('movieName',this.adminMovieForm.controls['movieName'].value);
    x.append('noOfTickets',this.adminMovieForm.controls['noOfTickets'].value);
    x.append('theatreId',this.adminMovieForm.controls['theatreId'].value);
    x.append('image',this.selectedFile, this.selectedFile.name);
    console.log(x);

    this.ms.addMovie(x).subscribe(data=>console.log(data));
                
  }

  fnModify(){
    // alert(" selected file "+ JSON.stringify(this.selectedFile));

    this.status = true;                
    var movie=new Movie();
    movie.movieId=this.adminMovieForm.controls['movieId'].value;
    movie.movieName=this.adminMovieForm.controls['movieName'].value;
    movie.noOfTickets=this.adminMovieForm.controls['noOfTickets'].value;
    movie.theatreId=this.adminMovieForm.controls['theatreId'].value;;
                                                                                                        // alert("fn MODIFY " +JSON.stringify(movie));
                                                                                                        //  alert("modify theatre id & name " +JSON.stringify(theatre));

    console.log(this.selectedFile);                               //modify
    const x = new FormData;
    x.append('movieId',this.adminMovieForm.controls['movieId'].value);
    x.append('movieName',this.adminMovieForm.controls['movieName'].value);
    x.append('noOfTickets',this.adminMovieForm.controls['noOfTickets'].value);
    x.append('theatreId',this.adminMovieForm.controls['theatreId'].value);
    x.append('image',this.selectedFile, this.selectedFile.name);
    console.log(x);
    this.ms.modifyMovie(x).subscribe(data=>console.log(data));

    // if(this.selectedFile != null ){
    //   this.ms.modifyMovie(x).subscribe(data=>console.log(data));
    // }
    // else{
    //   this.ms.modifyMovieWithoutPic(movie).subscribe(data=>console.log(data));

    // }
  }

  fnDelete(){
    this.status = true;                
    var movie=new Movie();

    movie.movieId=this.adminMovieForm.controls['movieId'].value;
    movie.movieName=this.adminMovieForm.controls['movieName'].value;
    movie.noOfTickets=this.adminMovieForm.controls['noOfTickets'].value;
    movie.theatreId=this.adminMovieForm.controls['theatreId'].value;
                                                                                                       // alert("remove theatre id & name " +JSON.stringify(movie));
    this.ms.removeMovie(movie.movieId).subscribe(data=>console.log(data));

  }

}


