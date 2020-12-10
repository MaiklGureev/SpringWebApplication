import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ServiceSection} from '../models/ss';

@Injectable({
  providedIn: 'root'
})
export class ServiceSectionService {

  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getServiceSectionById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/ServiceSection/byId', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public getServiceSectionList(): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/ServiceSection/all', {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }

  public delServiceSectionById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.delete('http://localhost:8080/ServiceSection/del', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public saveServiceSection(serviceSection: ServiceSection): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.post('http://localhost:8080/ServiceSection/save', serviceSection, {
      headers: headerAuth,
      responseType: 'text' as 'json'
    });
  }
}
