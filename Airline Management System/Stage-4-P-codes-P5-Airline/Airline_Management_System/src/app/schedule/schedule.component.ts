import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';

import { ScheduleService } from '../schedule.service';

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {
  scheduleForm: any;
  flight_id: any;
  constructor(private fb: FormBuilder, private ss: ScheduleService) {
    this.scheduleForm = this.fb.group({
      id: ['', Validators.required],
      flight_id: ['', Validators.required],
      sdate: ['', Validators.required],
      stime: ['', Validators.required],
      atime: ['', Validators.required],
      source: ['', Validators.required],
      destination: ['', Validators.required],
      duration: ['', Validators.required],
      repeat: ['', Validators.required]

    });
  }

  ngOnInit(): void {

  }

  addSchedule() {
    console.log(this.scheduleForm.value);
    this.ss.addSchedule(this.scheduleForm.value).subscribe((data) => {
      console.log(data);
    });
  }

  repeat() {
    console.log(this.scheduleForm.value);
    this.ss.repeat(this.scheduleForm.value).subscribe((data) => {
      console.log(data);
    })
  }

  get f() {
    return this.scheduleForm.controls;
  }

}
