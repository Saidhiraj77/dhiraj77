import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { BookDetailsComponent } from './book-details/book-details.component';
import { BookComponent } from './book/book.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { FaqsComponent } from './faqs/faqs.component';
import { HomeUserComponent } from './home-user/home-user.component';
import { HomeComponent } from './home/home.component';
import { InvoiceComponent } from './invoice/invoice.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MainHomeComponent } from './main-home/main-home.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { MovieComponent } from './movie/movie.component';
import { NoTicketsComponent } from './no-tickets/no-tickets.component';
import { PaymentBookComponent } from './payment-book/payment-book.component';
import { SearchMoviesComponent } from './search-movies/search-movies.component';
import { SeatsComponent } from './seats/seats.component';
import { SignupComponent } from './signup/signup.component';
import { TheatreComponent } from './theatre/theatre.component';
import { ViewProfileComponent } from './view-profile/view-profile.component';

const routes: Routes = [
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"home",component:HomeComponent},
  {path:"logout",component:LogoutComponent},
  {path:"homeUser",component:HomeUserComponent},
  {path:"movie",component:MovieComponent},
  {path:"theatre",component:TheatreComponent},
  {path:"booking",component:BookComponent},
  {path:"myBookings",component:BookDetailsComponent},
  {path:"payBook",component:PaymentBookComponent},
  {path:"seats", component:SeatsComponent},
  {path:"noTickets", component:NoTicketsComponent},
  {path:"invoice", component:InvoiceComponent},
  {path:"manageuser",component:ManageUsersComponent},
  {path:"mainHome",component:MainHomeComponent},
  {path:"searchMovies",component:SearchMoviesComponent},
  {path:"viewProfile", component:ViewProfileComponent},
  {path:"contactUs", component:ContactUsComponent},
  {path:"faqs",component:FaqsComponent},
  {path:"aboutUs", component:AboutUsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
