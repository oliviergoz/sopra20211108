import { Client } from './../model/client';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
  private static URL: string = 'http://localhost:8080/eshop/api/client';

  constructor(private http: HttpClient) {}

  public allClients(): Observable<any[]> {
    return this.http.get<any[]>(ClientService.URL);
  }

  public byId(id: number): Observable<Client> {
    return this.http.get<Client>(`${ClientService.URL}/${id}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete<Client[]>(`${ClientService.URL}/${id}`);
  }

  public insert(client: Client, password: string): Observable<Client> {
    const o = {
      prenom: client.prenom,
      nom: client.nom,
      civilite: client.civilite,
      user: { login: client.login, password: password },
    };
    return this.http.post<Client>(ClientService.URL, o);
  }

  public update(client: Client): Observable<Client> {
    console.log(client);
    return this.http.put<Client>(`${ClientService.URL}/${client.id}`, client);
  }
}
