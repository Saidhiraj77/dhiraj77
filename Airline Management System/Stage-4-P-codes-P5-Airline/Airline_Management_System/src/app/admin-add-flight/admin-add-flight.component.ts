import { JsonpClientBackend } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { AddflightService } from '../addflight.service';

@Component({
  selector: 'app-admin-add-flight',
  templateUrl: './admin-add-flight.component.html',
  styleUrls: ['./admin-add-flight.component.css']
})
export class AdminAddFlightComponent implements OnInit {
  addFlightForm: any;
  addFlight: any;
  flightDetail: any;
  constructor(private fb: FormBuilder, private af: AddflightService) {
    this.addFlightForm = this.fb.group({
      id: ["", Validators.required],
      flightNumber: ["", Validators.required],
      flightName: ["", Validators.required],
      model: ["", Validators.required],
      type: ["", Validators.required],
      economySeats: ["", Validators.required],
      businessSeats: ["", Validators.required],
      firstClassSeats: ["", Validators.required]
    });
  }

  fnAddFlight() {
    this.addFlight = this.addFlightForm.value;
    this.af.addFlightDetails(this.addFlight).subscribe(data => {
      console.log(data)
      if (data == 1) {
        alert("Flight successfully Added");
      }
    });
  }

  fnModifyFlight() {
    this.addFlight = this.addFlightForm.value;
    this.af.modifyFlightDetails(this.addFlight).subscribe(data => {
      console.log(data)
      if (data == 1) {
        alert("Flight successfully Modified");
      }
    });
  }

  fnDeleteFlight() {
    var id = this.addFlightForm.controls['id'].value;
    this.af.deleteFlightDetails(id).subscribe(data => {
      console.log(data)
      if (data == 1) {
        alert("Flight successfully Deleted");
      }
    });
  }


  fnSelectById(id: any) {
    this.af.GetDetailsById(id).subscribe(data => {
      console.log(data);
      this.addFlightForm.patchValue(data);
    });
  }

  ngOnInit(): void {
    this.af.GetAllDetails().subscribe(data => {
      console.log(data);
      if (data != null) {
        this.flightDetail = data;
      }
      else {
        return;
      }

    })
  }

  get f() {
    return this.addFlightForm.controls;
  }

}