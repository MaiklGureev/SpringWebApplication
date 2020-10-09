import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompaniesComponent } from './components/companies/companies.component';
import { AddressComponent } from './components/address/address.component';
import { ServiceClassComponent } from './components/service-class/service-class.component';
import { ServiceSectionComponent } from './components/service-section/service-section.component';
import { CompRightNormComponent } from './components/comp-right-norm/comp-right-norm.component';
import { CompanyComponent } from './components/company/company.component';

@NgModule({
  declarations: [
    AppComponent,
    CompaniesComponent,
    AddressComponent,
    ServiceClassComponent,
    ServiceSectionComponent,
    CompRightNormComponent,
    CompanyComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
