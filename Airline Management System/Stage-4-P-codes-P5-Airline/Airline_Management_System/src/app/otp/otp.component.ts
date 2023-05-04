import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { BookingService } from '../booking.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.css']
})
export class OtpComponent implements OnInit {
x=true;
txtOtp:string='';
paymentForm:any;
valid=false;
  constructor(private fb:FormBuilder,private bs:BookingService) {
    this.paymentForm=this.fb.group({
      email:[],
      otp:[],
    })
   }

  ngOnInit(): void {
  }

  fnPayment()
  {
      // alert("Payment successfull");
      this.valid=true;
  }

  fnGenerateOtp()
  {
      var email=this.paymentForm.controls['email'].value;
      this.bs.getOtp(email).subscribe((data)=>{
        console.log(data);
        var otp=data.toString();
        localStorage.setItem("otp",otp);
      });

  }

  fnValidateOtp()
  {
    // this.txtOtp
    var otp=localStorage.getItem("otp");
    console.log(otp);
    console.log("txtOpt is "+this.txtOtp);
    if(this.txtOtp==otp)
    {
      this.x=false;
    }else
    {
      this.x=true;
    }
  }
}
