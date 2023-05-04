import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminHomepageComponent } from './admin-homepage/admin-homepage.component';
import { HomePageComponent } from './home-page/home-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { SignupPageComponent } from './signup-page/signup-page.component';
import { UserHomepageComponent } from './user-homepage/user-homepage.component';
import { AboutusComponent } from './aboutus/aboutus.component';
const routes: Routes = [
  {path:'aboutus',component:AboutusComponent},
  {path:'home',component:HomePageComponent, },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  {path:'login',component:LoginPageComponent},
  {path:'signup',component:SignupPageComponent},
  {path:'adminPage',component:AdminHomepageComponent},
  {path:'userPage',component:UserHomepageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
