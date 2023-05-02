import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Book } from '../book';
import { BookService } from '../book.service';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';
import { PayBookService } from '../pay-book.service';
import { PaymentBookComponent } from '../payment-book/payment-book.component';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  movies:any;
  movieById:any;
  movieForm:any;
  book: Book = new Book();
  DisplayTickets:any;
  bookedimage:any;                       
  statusBook:any;
  zerotickets:number = 0;
  constructor(private fb:FormBuilder, private ms: MovieService, private bs:BookService, private router:Router, private ps: PayBookService) {
    this.movieForm=this.fb.group({
      movieId:[''],
      movieName:[''],
      theatreId:[''],
      theatreName:[''],
      tickets:['' ,[Validators.required, Validators.min(1)]],
      category:['',[Validators.required]],
      bookDate:['',[Validators.required]],
      showName:['',[Validators.required]]
    });
   }

  ngOnInit(): void {
    this.ms.getAllMovie().subscribe((data)=>{
      console.log(data);
      this.movies=data;                                  
     });
  }
  fnBook(mov:any){
                                                                                    // alert("Entering into Book fn " + JSON.stringify(mov));
    this.statusBook = true;
    if(localStorage.getItem('user')==null)
    {
      console.log("NOt logged in.")
      return;
    }
    var str=localStorage.getItem('user');
    if(str!=null){
      var user=JSON.parse(str);
                                                                                      // alert(" user object " + JSON.stringify(str));
      var customer_id=user.userId;
         this.book.bookDate=new Date();
         this.book.theatreId=mov.theatreId;
         this.book.movieId=mov.movieId;
         this.book.customerId=customer_id;
      
      this.ms.getMovieById(this.book.movieId).subscribe((data)=>{
      this.movieForm.patchValue(data);                       
      });

      this.ms.getMovieById(this.book.movieId).subscribe((data)=>{
        console.log(data);
        this.movieById=data; 
        this.bookedimage=this.movieById.image;                                                       
        localStorage.setItem("bookimage", this.bookedimage);                                           
                                                                                        // alert(JSON.stringify(this.bookedimage));
        var availableTickets = this.movieById.noOfTickets;
        this.DisplayTickets = availableTickets;
                                                                                         // alert(" display tickets  " + this.DisplayTickets);
      });
                                                                                        //  alert(JSON.stringify(" book " + this.book))
       localStorage.setItem("confirmBook", JSON.stringify(this.book));
       console.log(this.book);

   }
                                                                                         // alert(str);
  }
  fnAdd(){
  
    this.book.tickets =  this.movieForm.controls['tickets'].value;
    this.book.seatType = this.movieForm.controls['category'].value;
    var bookDate = this.movieForm.controls['bookDate'].value;
    var showName = this.movieForm.controls['showName'].value;
    localStorage.setItem("bookDate", bookDate);
    localStorage.setItem("showName", showName);
                                                                                          // alert("show Name" +  showName );
    this.ms.getMovieById(this.book.movieId).subscribe((data)=>{
      console.log(data);
      this.movieById=data; 
                                                                                          //  alert("Booked Movie Id "+ JSON.stringify(this.movieById)); 
      var availableTickets = this.movieById.noOfTickets;
      this.DisplayTickets = availableTickets;
                                                                                          // alert(" display available tickets  " + this.DisplayTickets);
      var enteredTickets = this.book.tickets;
      if(enteredTickets == this.zerotickets){
                                                                                         alert(" Entered tickets should not be 0");
        this.router.navigate(['/noTickets']);
        return
      }  

      if(enteredTickets <= availableTickets ){
        availableTickets = availableTickets - enteredTickets;
                                                                                          // alert("available tickets after booking" +availableTickets);
        this.movieById.noOfTickets=availableTickets;
                                                                                          //alert("no of tickets updated to db " + this.movieById.noOfTickets);
                                                                                          //alert("Modify movie object " + JSON.stringify(this.movieById));
       this.ms.modifyMovieticket(this.movieById).subscribe(data=>console.log(data));
       this.router.navigate(['/payBook']);
      }else{
        this.router.navigate(['/noTickets']);
      }

     });
    localStorage.setItem("movieName", this.movieById.movieName );
    localStorage.setItem("theatreName", this.movieById.theatreName );
                                                                                           //  alert(JSON.stringify(" book object to local storage " + this.book))
     localStorage.setItem("confirmBook", JSON.stringify(this.book));
     console.log(this.book);
                                                                                           //alert("before booking, id " + JSON.stringify(this.book));
   this.bs.bookTicket(this.book).subscribe(data=>console.log(data)); 
   this.ps.bookTicket(this.book);  
  }
  fnDelete(){}
}
function subscribe(arg0: (data: any) => void) {
  throw new Error('Function not implemented.');
}

