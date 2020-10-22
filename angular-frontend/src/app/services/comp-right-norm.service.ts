import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
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
    return this.http.get('http://localhost:8080/CompRightNorm/byId', {params: new HttpParams().set('id', String(id))});
  }

  public getCompRightNormList(): Observable<any> {
    return this.http.get('http://localhost:8080/CompRightNorm/all');
  }

  public delCompRightNormById(id: number): Observable<any> {
    return this.http.delete('http://localhost:8080/CompRightNorm/del', {params: new HttpParams().set('id', String(id))});
  }

  public saveCompRightNorm(compRightNorm: CompRightNorm): void {
    this.http.post('http://localhost:8080/CompRightNorm/save', compRightNorm);
  }
}
