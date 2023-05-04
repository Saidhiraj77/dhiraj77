import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';
import { MyUser } from '../my-user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  signupForm:any;
  signStatus:any;
  users:any;
  submitted:boolean = false;
  message:string='';
  txtOtp:string='';
  x=true;
  constructor(private fb:FormBuilder, private us:UserService) { 
    this.signupForm=this.fb.group({
      username:['',[Validators.required,  Validators.minLength(5), Validators.maxLength(10)]],
      email:['', [Validators.required, Validators.email]],
      // phone:['', [Validators.required, Validators.pattern('^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$')]],
      phone:['', [Validators.required, Validators.pattern("^((\\+91-?)|0)?[0-9]{10}$")]],

      gender:[],
      password:['',[Validators.required, Validators.minLength(5), Validators.maxLength(10)]],
      cpassword:['',[Validators.required]],
      otp:[]
    },
    {
      validators : this.MustMatch('password','cpassword')
    })
  }
  MustMatch(controlName: string, matchingControlName:string){
    return(formGroup: FormGroup)=>{
      const control = formGroup.controls[controlName];
      const matchingControl = formGroup.controls[matchingControlName];
      if(matchingControl.errors && !matchingControl.errors.MustMatch){
        return
      }
      if(control.value !== matchingControl.value){
        matchingControl.setErrors({MustMatch:true});
      }
      else{
        matchingControl.setErrors(null);
      }
    }
  }
  get f () {return this.signupForm.controls}

  ngOnInit(): void {
    this.us.getAllUsers().subscribe((data)=>{
      console.log(data);
      this.users=data;                                  
     })
  }
//   confirmedValidator(controlName: string, matchingControlName: string){
//     return (formGroup: FormGroup) => {
//         const control = formGroup.controls[controlName];
//         const matchingControl = formGroup.controls[matchingControlName];
//         if (matchingControl.errors && !matchingControl.errors.confirmedValidator) {
//             return;
//         }
//         if (control.value !== matchingControl.value) {
//             matchingControl.setErrors({ confirmedValidator: true });
//         } else {
//             matchingControl.setErrors(null);
//         }
//     }
// }



  
  signup()
  {
    this.submitted =true;
    this.signStatus = true;
    var myuser=new MyUser();
    myuser.username=this.signupForm.controls['username'].value;
    myuser.email = this.signupForm.controls['email'].value;
    myuser.phone = this.signupForm.controls['phone'].value;
    myuser.gender = this.signupForm.controls['gender'].value;
    myuser.password=this.signupForm.controls['password'].value;
    myuser.role="user";
                                                                                                                // alert(JSON.stringify(myuser));
    this.us.signup(myuser).subscribe(data=>console.log(data));
  }
  
  fnGenerateOtp()
  {
      this.message = "OTP Sent Successfully"
      var email=this.signupForm.controls['email'].value;
      this.us.getOtp(email).subscribe((data)=>{
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
