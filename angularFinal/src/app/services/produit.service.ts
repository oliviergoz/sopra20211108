import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  url: string = 'http://localhost:8080/eshop/api/produit';

  constructor(private http: HttpClient) {}

  public allProduits(): Observable<any> {
    return this.http.get(this.url);
  }
}
