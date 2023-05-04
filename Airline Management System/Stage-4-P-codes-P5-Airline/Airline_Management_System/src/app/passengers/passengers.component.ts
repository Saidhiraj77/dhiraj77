import { Component, DoCheck, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { BookingService } from '../booking.service';
import { Passenger } from '../passenger';
import { PassengerService } from '../passenger.service';

@Component({
  selector: 'app-passengers',
  templateUrl: './passengers.component.html',
  styleUrls: ['./passengers.component.css']
})
export class PassengersComponent implements OnInit, DoCheck {
  count = 0;
  booking: any;
  passengerForm: any;
  booking_id: any;
  enable: any;
  constructor(private fb: FormBuilder, private ps: PassengerService, private bs: BookingService, private router: Router) {
    this.passengerForm = this.fb.group({
      salutation: ['',Validators.required],
      firstName: ['',Validators.required],
      lastName: ['',Validators.required],
      age: ['',Validators.required],
      gender: ['',Validators.required]
    });
  }

  getBookingIdAuto() {
    this.bs.getBookingId().subscribe((data) => {
      if(data!=0)
      {
      console.log("Booking_id " + data);
      this.booking_id = data;
      }
      this.ps.getPassengerCount(this.booking_id).subscribe(data => {
        this.count = Number(data);
      });  
    });
  }
  getCountOfPassengers() {
      // console.log(this.count);
      // console.log("Passenger Count " + this.count)

      // console.log("No of Passengers whose tickets are to be booked" + localStorage.getItem("count"))
    // });

  }

  fnBooked(){
    this.router.navigate(['/','payment']);
    
  }

  fnAddPassenger() {
    var i = 1;
    var passenger = new Passenger();
    passenger.id = 0;
    passenger.booking_id = this.booking_id;
    passenger.salutation = this.passengerForm.controls['salutation'].value;
    passenger.firstName = this.passengerForm.controls['firstName'].value;
    passenger.lastName = this.passengerForm.controls['lastName'].value;
    passenger.age = this.passengerForm.controls['age'].value;
    passenger.gender = this.passengerForm.controls['gender'].value;
    if (this.count < Number(localStorage.getItem("count"))) {
      this.ps.addPassengerDetails(passenger).subscribe(data => {
        console.log(data)
        if (data == 1 && (this.enable == true)) {
          alert("Passenger Details of " + passenger.firstName + " " + passenger.lastName + " Got added")
        }
      });
    }
  }

  get f()
  {
    return this.passengerForm.controls;
  }
  ngDoCheck(): void {
    if (this.count == Number(localStorage.getItem("count"))) {
      this.enable = false;
      this.booking = true;
      // alert("button enabled");
    }
    else {
      // alert("button disabled");
      this.booking = false;
      this.enable = true;

    }
  }
  ngOnInit(): void {

  }

}
