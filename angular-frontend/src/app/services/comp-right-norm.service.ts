import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CompRightNorm} from '../models/comp-right-norm';

@Injectable({
  providedIn: 'root'
})
export class CompRightNormService {

  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getCompRightNormById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/CompRightNorm/byId', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public getCompRightNormList(): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/CompRightNorm/all', {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }

  public delCompRightNormById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.delete('http://localhost:8080/CompRightNorm/del', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public saveCompRightNorm(compRightNorm: CompRightNorm): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.post('http://localhost:8080/CompRightNorm/save', compRightNorm, {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }
}
