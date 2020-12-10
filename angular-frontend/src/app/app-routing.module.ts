import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {WelcomeComponent} from './components/welcome/welcome.component';
import {AddressComponent} from './components/address/address.component';
import {ServiceClassComponent} from './components/service-class/service-class.component';
import {ServiceSectionComponent} from './components/service-section/service-section.component';
import {CompRightNormComponent} from './components/comp-right-norm/comp-right-norm.component';
import {CompanyComponent} from './components/company/company.component';
import {LoginComponent} from './components/login/login.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'welcome', component: WelcomeComponent},
  {path: 'address', component: AddressComponent},
  {path: 'sc', component: ServiceClassComponent},
  {path: 'ss', component: ServiceSectionComponent},
  {path: 'crn', component: CompRightNormComponent},
  {path: 'company', component: CompanyComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
