import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminAddFlightComponent } from './admin-add-flight/admin-add-flight.component';
import { BookingComponent } from './booking/booking.component';
import { FaqsComponent } from './faqs/faqs.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MytripComponent } from './mytrip/mytrip.component';
import { OtpComponent } from './otp/otp.component';
import { PassengersComponent } from './passengers/passengers.component';
import { PaymentComponent } from './payment/payment.component';
import { ProfileComponent } from './profile/profile.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { SignupComponent } from './signup/signup.component';
const routes: Routes = [{ path: "login", component: LoginComponent },
{ path: 'logout', component: LogoutComponent },
{ path: 'signup', component: SignupComponent },
{ path: 'home', component: HomeComponent },
{ path: 'add-flight', component: AdminAddFlightComponent },
{ path: 'booking', component: BookingComponent },
{ path: 'faqs', component: FaqsComponent },
{ path: 'schedule', component: ScheduleComponent },
{ path: 'search', component: SearchFlightComponent },
{ path: 'passengers', component: PassengersComponent},
{ path: 'payment', component: PaymentComponent },
{ path: 'otp', component: OtpComponent },
{ path: 'mytrips' , component: MytripComponent},
{ path: 'profile' , component: ProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
