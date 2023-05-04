import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-main-home',
  templateUrl: './main-home.component.html',
  styleUrls: ['./main-home.component.css']
})
export class MainHomeComponent implements OnInit {

  status:any;
  constructor() { }

  ngOnInit(): void {
  }
fnBook(){
this.status=true;
}
}
