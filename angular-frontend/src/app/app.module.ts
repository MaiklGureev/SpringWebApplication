import {BrowserModule} from '@angular/platform-browser';
import {enableProdMode, NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AddressComponent} from './components/address/address.component';
import {ServiceClassComponent} from './components/service-class/service-class.component';
import {ServiceSectionComponent} from './components/service-section/service-section.component';
import {CompRightNormComponent} from './components/comp-right-norm/comp-right-norm.component';
import {CompanyComponent} from './components/company/company.component';
import {WelcomeComponent} from './components/welcome/welcome.component';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

enableProdMode();

@NgModule({
  declarations: [
    AppComponent,
    AddressComponent,
    ServiceClassComponent,
    ServiceSectionComponent,
    CompRightNormComponent,
    CompanyComponent,
    WelcomeComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],

  bootstrap: [AppComponent]
})
export class AppModule {
}
