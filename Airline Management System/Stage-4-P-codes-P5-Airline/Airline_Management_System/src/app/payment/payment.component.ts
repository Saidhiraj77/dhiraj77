import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  message: any;
  value: any;
  paymentForm:any;
  constructor(private fb:FormBuilder,private router: Router) {
    this.paymentForm=this.fb.group({
      type:['',Validators.required],
      cardNumber:['',Validators.required],
      eDate:['',Validators.required],
      cvc:['',Validators.required],
      amount:['',Validators.required]

    });
   }


  fnSendOtp() {
    this.router.navigate(['/', 'otp'])
  }
  ngOnInit(): void {
    this.message = localStorage.getItem("payment");
    if (this.message == 0) {
      this.value = false;
    }
    else {
      this.value = true;
    }

  }

  get f()
  {
    return this.paymentForm.controls;
  }

}
