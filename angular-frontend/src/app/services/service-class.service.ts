import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.http.get('http://localhost:8080/ServiceClass/byId', {params: new HttpParams().set('id', String(id))});
  }

  public getServiceClassList(): Observable<any> {
    return this.http.get('http://localhost:8080/ServiceClass/all');
  }

  public delServiceClassById(id: number): void {
    this.http.delete('http://localhost:8080/ServiceClass/del', {params: new HttpParams().set('id', String(id))})
      .subscribe(value => {
        console.log(value);
      });
  }

  public saveServiceClass(serviceClass: ServiceClass): void {
    this.http.post('http://localhost:8080/ServiceClass/save', serviceClass);
  }
}
