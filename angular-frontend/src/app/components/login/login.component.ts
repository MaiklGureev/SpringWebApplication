import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {DataService} from '../../services/data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  login: string;
  password: string;
  isHideErrorMessage = true;


  constructor(private data: DataService,
              private http: HttpClient,
              private router: Router) {
  }

  ngOnInit(): void {
    sessionStorage.clear();
    this.data.changeMessage('hideNavBar');
  }


  public getLogin(): void {
    sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + btoa(this.login + ':' + this.password)});

    this.http.get(
      'http://localhost:8080/login',
      {headers: headerAuth, responseType: 'text' as 'json'}
    ).subscribe(
      isValid => {
        console.log(isValid);
        if (isValid) {
          this.isHideErrorMessage = true;
          this.router.navigate(['/welcome']);
          this.data.changeMessage('showNavBar');
          return;
        } else {
          console.log('error');
          this.data.changeMessage('hideNavBar');
          this.isHideErrorMessage = false;
        }
      });
  }


}
