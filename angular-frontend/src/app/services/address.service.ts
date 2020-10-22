import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.http.get('http://localhost:8080/Address/byId', {params: new HttpParams().set('id', String(id))});
  }

  public getAddressesList(): Observable<any> {
    return this.http.get('http://localhost:8080/Address/all');
  }

  public delAddressById(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/Address/del', {params: new HttpParams().set('id', String(id))});
  }

  public saveAddress(address: Address): void {
    this.http.post('http://localhost:8080/Address/save', address);
  }
}
