import { DatePipe } from '@angular/common';
import { LocalizedString } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
import { ScheduleService } from '../schedule.service';
// import * as moment from 'moment';
import { PaymentService } from '../payment.service';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent implements OnInit {
  flightId: any;
  bookingForm: any;
  date: any;

  constructor(private fb: FormBuilder, private pay: PaymentService, private router: Router, private ss: ScheduleService, private bs: BookingService) {
    this.bookingForm = this.fb.group({
      flight_id: ['', Validators.required],
      class: ['', Validators.required],
      source: ['', Validators.required],
      destination: ['', Validators.required],
      sdate: ['', Validators.required],
      count: ['', Validators.required]
    })
  }

  ngOnInit(): void {

    if (localStorage.getItem("user") != null) {
      this.flightId = localStorage.getItem("flight");
      this.ss.findScheduleById(this.flightId).subscribe((data) => {
        console.log(data)
        var flightObject = JSON.parse(JSON.stringify(data));
        this.date = flightObject.sdate;
        this.bookingForm.patchValue(data);
      });
    }
    else {
      alert("You Have not Logged in. Please Login...")
      this.router.navigate(['/', 'login']);
    }
  }

  get f() {
    return this.bookingForm.controls;
  }


  fnBooking() {
    var booking = new Booking();
    booking.id = 0;
    booking.schedule_id = this.flightId;
    booking.classtype = this.bookingForm.controls['class'].value;
    booking.passengers = this.bookingForm.controls['count'].value;
    localStorage.setItem("count", this.bookingForm.controls['count'].value);
    var id = localStorage.getItem("userid");
    booking.user_id = id;
    if (this.bookingForm.controls['count'].value > 0) {
      this.bs.addBookingDetails(booking).subscribe(data => {
        console.log(data);
        if (data != 0) {
          this.pay.GetPayment(booking.classtype, booking.passengers).subscribe((data) => {
            // alert(data);
            localStorage.setItem("payment", JSON.stringify(data));
          });
          this.router.navigate(['/', 'passengers']);

        }
        else {
          localStorage.removeItem("payment");
          return;
        }
      })
    }
  }
}
