import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.http.get('http://localhost:8080/ServiceSection/byId', {params: new HttpParams().set('id', String(id))});
  }

  public getServiceSectionList(): Observable<any> {
    return this.http.get('http://localhost:8080/ServiceSection/all');
  }

  public delServiceSectionById(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/ServiceSection/del', {params: new HttpParams().set('id', String(id))});
  }

  public saveServiceSection(serviceSection: ServiceSection): void {
    this.http.post('http://localhost:8080/ServiceSection/save', serviceSection);
  }
}
