import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AuthGuard} from "./auth.guard";
import {LoginComponent} from "./login/login.component";
import {CallbackComponent} from "./callback/callback.component";
import { CreateCandidateComponent } from './create-candidate/create-candidate.component';
import { TabsBarComponent } from './tabs-bar/tabs-bar.component';
import { ViewEditDeleteComponent } from './view-edit-delete/view-edit-delete.component';
import { TrendsComponent } from './trends/trends.component';
import { OptionsBarComponent } from './options-bar/options-bar.component';
import { PrintCadidateComponent } from './print-cadidate/print-cadidate.component';
import { EditingFormComponent } from './editing-form/editing-form.component';
import { LogsComponentComponent } from './logs-component/logs-component.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'callback', component: CallbackComponent},
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path:'home/newone/trends', pathMatch:'full',component:TrendsComponent,canActivate:[AuthGuard]},
    { path: 'home/newone/new-cand', pathMatch: 'full',component: CreateCandidateComponent,canActivate:[AuthGuard]},
  { path: 'home/newone', pathMatch: 'full',component: TabsBarComponent,canActivate:[AuthGuard]},
  { path: 'home/newone/view-bar', pathMatch: 'full',component: ViewEditDeleteComponent,canActivate:[AuthGuard] },
  {path:'home/notfound',component:OptionsBarComponent,canActivate:[AuthGuard]},

 {path:'editing',component:EditingFormComponent}, 
  {path:'home/newone/home',component:HomeComponent},
  {path:'print',component:PrintCadidateComponent},

  {path:'home/newone/logs',component:LogsComponentComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
