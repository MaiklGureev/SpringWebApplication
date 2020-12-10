import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {DataService} from '../../services/data.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  isHideForm = false;


  constructor(private data: DataService,
              private http: HttpClient,
              private router: Router) {

    this.data.currentMessage.subscribe(message => {
      if (message === 'showNavBar') {
        this.isHideForm = false;
      } else if (message === 'hideNavBar') {
        this.isHideForm = true;
      }
    });

  }

  ngOnInit(): void {
    //this.checkAuth();
    this.data.currentMessage.subscribe(message => {
      if (message === 'showNavBar') {
        this.isHideForm = false;
      } else if (message === 'hideNavBar') {
        this.isHideForm = true;
      }
    });
  }

  public checkAuth(): void {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    this.http.get(
      'http://localhost:8080/login',
      {headers: headerAuth, responseType: 'text' as 'json'}
    ).subscribe(
      isValid => {
        console.log(isValid);
        if (isValid) {
          this.isHideForm = false;
        } else {
          this.isHideForm = true;
          this.logOut();
        }
      });
  }

  logOut(): void {
    sessionStorage.clear();
    this.router.navigate(['login']);
    this.isHideForm = true;
  }
}
