import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingpageComponent } from './landingpage/landingpage.component';
import { CreateUserComponent } from './create-user/create-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';


const routes: Routes = [
  {path:"", component:LandingpageComponent},
  {path:"createuser", component:CreateUserComponent},
  {path:"updateuser", component:UpdateUserComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
