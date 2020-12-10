import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Company} from '../models/company';

@Injectable({
  providedIn: 'root'
})


export class CompanyService {
  private http: HttpClient;


  constructor(http: HttpClient) {
    this.http = http;
  }

  public getCompanyById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/Company/byId', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public getCompaniesList(): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/Company/all', {headers: headerAuth, responseType: 'text' as 'json'});
  }

  public delCompanyById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.delete('http://localhost:8080/Company/del', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public saveCompany(comp: Company): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.post('http://localhost:8080/Company/save', comp, {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }
}
