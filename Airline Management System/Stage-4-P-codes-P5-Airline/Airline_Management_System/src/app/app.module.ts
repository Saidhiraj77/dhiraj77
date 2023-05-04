import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NavigationComponent } from './navigation/navigation.component';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { CourosalComponent } from './courosal/courosal.component';
import { FooterComponent } from './footer/footer.component';
import { AdminAddFlightComponent } from './admin-add-flight/admin-add-flight.component';
import { BookingComponent } from './booking/booking.component';
import { FaqsComponent } from './faqs/faqs.component';
import { ScheduleComponent } from './schedule/schedule.component';
import { SearchFlightComponent } from './search-flight/search-flight.component';
import { PaymentComponent } from './payment/payment.component';
import { OtpComponent } from './otp/otp.component';
import { PassengersComponent } from './passengers/passengers.component';
import { MytripComponent } from './mytrip/mytrip.component';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    NavigationComponent,
     HomeComponent,
     SignupComponent,
     CourosalComponent,
     FooterComponent,
     AdminAddFlightComponent,
     BookingComponent,
     FaqsComponent,
     ScheduleComponent,
     SearchFlightComponent,
     PaymentComponent,
     OtpComponent,
     PassengersComponent,
     MytripComponent,
     ProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
