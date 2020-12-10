import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Address} from '../models/address';

@Injectable({
  providedIn: 'root'
})
export class AddressService {

  private http: HttpClient;

  constructor(http: HttpClient) {
    this.http = http;
  }

  public getAddressById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/Address/byId',
      {headers: headerAuth, responseType: 'text' as 'json', params: new HttpParams().set('id', String(id))});
  }

  public getAddressesList(): Observable<any> {
    console.log(sessionStorage.getItem('token'));
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.get('http://localhost:8080/Address/all', {headers: headerAuth, responseType: 'text' as 'json'});
  }

  public delAddressById(id: number): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.delete('http://localhost:8080/Address/del', {
      headers: headerAuth,
      responseType: 'text' as 'json',
      params: new HttpParams().set('id', String(id))
    });
  }

  public saveAddress(address: Address): Observable<any> {
    const headerAuth = new HttpHeaders({Authorization: 'Basic ' + sessionStorage.getItem('token')});
    return this.http.post(
      'http://localhost:8080/Address/save',
      address,
      {headers: headerAuth, responseType: 'text' as 'json'});
  }
}
