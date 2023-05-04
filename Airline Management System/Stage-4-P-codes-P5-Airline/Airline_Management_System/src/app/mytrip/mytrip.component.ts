import { Component, DoCheck, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { PassengerService } from '../passenger.service';
import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-mytrip',
  templateUrl: './mytrip.component.html',
  styleUrls: ['./mytrip.component.css']
})
export class MytripComponent implements OnInit {
  booking_id: any;
  bookingHistory: any;
  currentBooking: any;
  source:any;
  destination:any;
  constructor(private bs: BookingService, private ps: PassengerService, private router: Router,private ss:ScheduleService) { }

  fnDeleteBooking() {
    alert("Your Booking for Booking id " + this.booking_id+ " Has been Cancelled")
    this.bs.deleteBookingDetails(this.booking_id).subscribe((data) => {
      console.log(data)
      if (data == 1) {
        this.ps.deleteByBookingId(this.booking_id).subscribe(data => console.log(data));
      }
      this.router.navigate(['/','mytrips'])
    });
  }


  ngOnInit(): void {
    console.log(localStorage.getItem("user"));
    if (localStorage.getItem("user") != null) 
    {
      this.bs.getBookingDetailsByUserId(localStorage.getItem("userid")).subscribe(data => {
        console.log(data)
        this.bookingHistory = data;
      })
      this.ss.findScheduleById(Number(localStorage.getItem("flight"))).subscribe((data)=>{
        var obj=JSON.parse(JSON.stringify(data));
        this.source=obj.source;
        this.destination=obj.destination;
        

      })

      this.bs.getBookingId().subscribe((data) => {
        // console.log("Booking_id " + data);
        this.booking_id = data;
        this.bs.getCurrentBookingDetails(this.booking_id, localStorage.getItem("userid")).subscribe(data => {
          console.log(data);
          var obj=JSON.parse(JSON.stringify(data));
           this.currentBooking = data;

        })
             });
    }
    else {
      alert("Please login to view your trips");
      this.router.navigate(['/', 'login']);
    }
  }
}
