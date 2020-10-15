import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddressComponent } from './components/address/address.component';
import { ServiceClassComponent } from './components/service-class/service-class.component';
import { ServiceSectionComponent } from './components/service-section/service-section.component';
import { CompRightNormComponent } from './components/comp-right-norm/comp-right-norm.component';
import { CompanyComponent } from './components/company/company.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const appRoutes: Routes = [
  {path: '', component: WelcomeComponent},
  {path: 'address', component: AddressComponent},
  {path: 'sc', component: ServiceClassComponent},
  {path: 'ss', component: ServiceSectionComponent},
  {path: 'crn', component: CompRightNormComponent},
  {path: 'company', component: CompanyComponent}
];
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
    AppRoutingModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
