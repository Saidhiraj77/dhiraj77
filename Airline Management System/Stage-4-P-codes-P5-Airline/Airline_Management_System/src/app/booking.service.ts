import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  url: string = "http://localhost:8080/booking"
  url1: string = "http://localhost:8080/otp"
  constructor(private http: HttpClient) { }



  addBookingDetails(booking: any) {
    return this.http.post(this.url, booking);
  }

  getBookingByID(id: any) {
    return this.http.get(this.url + "/" + id);
  }

  modifyBookingDetails(booking: any) {
    return this.http.put(this.url, booking);
  }

  deleteBookingDetails(id: any) {
    return this.http.delete(this.url + "/" + id);
  }


  getCurrentBookingDetails(bookingid: any,userid:any) {
    return this.http.get(this.url + "/currentBooking/" + bookingid+"/"+userid);
  }

  getBookingId() {
    return this.http.get(this.url + "/bookingid");
  }


  getOtp(email: any) {
    return this.http.get(this.url1 + "/" + email);
  }

  getBookingDetailsByUserId(user_id: any) {
    return this.http.get(this.url + "/mytrips/" + user_id);
  }

}
