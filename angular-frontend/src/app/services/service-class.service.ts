import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ServiceClass} from '../models/sc';

@Injectable({
  providedIn: 'root'
})
export class ServiceClassService {

  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getServiceClassById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/ServiceClass/byId', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public getServiceClassList(): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/ServiceClass/all', {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }

  public delServiceClassById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.delete('http://localhost:8080/ServiceClass/del', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public saveServiceClass(serviceClass: ServiceClass): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.post('http://localhost:8080/ServiceClass/save', serviceClass, {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }
}
