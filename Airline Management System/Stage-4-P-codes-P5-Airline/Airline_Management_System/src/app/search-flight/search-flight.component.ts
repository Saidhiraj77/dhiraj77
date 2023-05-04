import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ScheduleService } from '../schedule.service';
import { ScheduleComponent } from '../schedule/schedule.component';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  searchFlightForm: any;
  flightchart: any;
  notavailable: any;

  constructor(private fb: FormBuilder, private ss: ScheduleService, private router: Router) {
    this.searchFlightForm = this.fb.group({
      source: [],
      destination: [],
      jdate: []
    })

  }

  fnBook(id: any) {
    this.router.navigate(['/', 'booking']);
    localStorage.setItem("flight", id);
  }

  fnSearch() {
    var source = this.searchFlightForm.controls['source'].value;
    var destination = this.searchFlightForm.controls['destination'].value;
    var date = this.searchFlightForm.controls['jdate'].value;
    this.ss.findSchedulesBySourceDestinationDate(source, destination).subscribe((data) => {
      console.log(data)
      if (data.valueOf() != 0) {
        this.flightchart = data;
      }
      else {
        this.notavailable = true;

      }

    });



  }

  ngOnInit(): void {
  }

}
