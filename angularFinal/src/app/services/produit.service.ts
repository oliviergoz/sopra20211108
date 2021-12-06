import { Produit } from './../model/produit';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  url: string = 'http://localhost:8080/eshop/api/produit';

  constructor(private http: HttpClient) {}

  public allProduits(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.url);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(this.url + '/' + id);
  }

  public getById(id: number): Observable<Produit> {
    return this.http.get<Produit>(this.url + '/' + id);
  }

  public insert(produit: Produit): Observable<Produit> {
    console.log(produit);
    const o = {
      nom: produit.nom,
      description: produit.description,
      prix: produit.prix,
    };
    console.log(o);
    return this.http.post<Produit>(this.url, o);
  }

  public update(produit: Produit): Observable<Produit> {
    console.log(produit);
    return this.http.put<Produit>(this.url + '/' + produit.id, produit);
  }
}
