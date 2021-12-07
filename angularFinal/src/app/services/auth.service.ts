import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  public auth(login: string, password: string): Observable<any> {
    const httpHeaders: HttpHeaders = new HttpHeaders({
      Authorization: 'Basic ' + btoa(login + ':' + password),
      'Content-Type': 'application/json',
    });
    return this.http.get('http://localhost:8080/eshop/api/auth', {
      headers: httpHeaders,
    });
  }
}
