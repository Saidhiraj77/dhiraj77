import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PassengerService {
  url: string = "http://localhost:8080/passengerdetails";
  constructor(private http: HttpClient) { }

  addPassengerDetails(passenger: any) {
    return this.http.post(this.url, passenger);
  }

  getAllPassengers() {
    return this.http.get(this.url);
  }

  getPassengerById(id: any) {
    return this.http.get(this.url + "/" + id);
  }

  modifyPassengerDetails(passenger: any) {
    return this.http.put(this.url, passenger);
  }

  deletePassengerById(id: any) {
    return this.http.delete(this.url + "/" + id);
  }

  getPassengerCount(booking_id: any) {
    return this.http.get(this.url + "/count/" + booking_id);
  }


  deleteByBookingId(booking_id: any) {
    return this.http.delete(this.url + "/bookingid/" + booking_id);
  }
}
