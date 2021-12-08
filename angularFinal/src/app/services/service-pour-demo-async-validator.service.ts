import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ServicePourDemoAsyncValidatorService {
  constructor(private http: HttpClient) {}

  public checkDataInList(data: string): Observable<boolean> {
    return this.http.get<boolean>(
      'http://localhost:8080/eshop/api/demo/' + data
    );
  }
}
