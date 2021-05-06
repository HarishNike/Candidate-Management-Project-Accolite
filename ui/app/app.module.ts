import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CallbackComponent } from './callback/callback.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthHeaderInterceptor} from "./auth-header.interceptor";
import { OptionsBarComponent } from './options-bar/options-bar.component';
import { TabsBarComponent } from './tabs-bar/tabs-bar.component';
import { CreateCandidateComponent } from './create-candidate/create-candidate.component';
import { ViewEditDeleteComponent } from './view-edit-delete/view-edit-delete.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SocialLoginModule } from 'angularx-social-login';
import { NgxPaginationModule } from 'ngx-pagination';
import { TrendsComponent } from './trends/trends.component';
// import { TrendsComponent } from './trends/trends.component';
import { NgxChartsModule } from '@swimlane/ngx-charts';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { PrintCadidateComponent } from './print-cadidate/print-cadidate.component';
import { EditingFormComponent } from './editing-form/editing-form.component';
import { LogsComponentComponent } from './logs-component/logs-component.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    CallbackComponent,
    OptionsBarComponent,
    TabsBarComponent,
    CreateCandidateComponent,
    ViewEditDeleteComponent,
    TrendsComponent,
    PrintCadidateComponent,
    EditingFormComponent,
    LogsComponentComponent,
 
  // le
 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    SocialLoginModule,
    HttpClientModule,
    NgxPaginationModule,
    NgxChartsModule,
    BrowserModule,
    BrowserAnimationsModule
  
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthHeaderInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
