import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './signup/signup.component';
import { MenuComponent } from './menu/menu.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { FooterComponent } from './footer/footer.component';
import { CouraselMovieComponent } from './courasel-movie/courasel-movie.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { MovieComponent } from './movie/movie.component';
import { TheatreComponent } from './theatre/theatre.component';
import { BookComponent } from './book/book.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { PaymentBookComponent } from './payment-book/payment-book.component';
import { SeatsComponent } from './seats/seats.component';
import { NoTicketsComponent } from './no-tickets/no-tickets.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { MainHomeComponent } from './main-home/main-home.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';
import { ViewProfileComponent } from './view-profile/view-profile.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqsComponent } from './faqs/faqs.component';
import { AboutUsComponent } from './about-us/about-us.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    MenuComponent,
    HomeComponent,
    LogoutComponent,
    FooterComponent,
    CouraselMovieComponent,
    HomeUserComponent,
    MovieComponent,
    TheatreComponent,
    BookComponent,
    BookDetailsComponent,
    PaymentBookComponent,
    SeatsComponent,
    NoTicketsComponent,
    InvoiceComponent,
    ManageUsersComponent,
    MainHomeComponent,
    SearchMoviesComponent,
    ViewProfileComponent,
    ContactUsComponent,
    FaqsComponent,
    AboutUsComponent
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
