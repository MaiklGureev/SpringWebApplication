import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.http.get('http://localhost:8080/Company/byId', {params: new HttpParams().set('id', String(id))});
  }

  public getCompaniesList(): Observable<any> {
    return this.http.get('http://localhost:8080/Company/all');
  }

  public delCompanyById(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/Company/del', {params: new HttpParams().set('id', String(id))});
  }

  public saveCompany(comp: Company): Observable<any> {
    return this.http.post('http://localhost:8080/Company/save', comp);
  }
}
