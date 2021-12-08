import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { Produit } from '../model/produit';

@Injectable({
  providedIn: 'root',
})
export class ValiderService {
  constructor(private http: HttpClient) {}

  public enregistrer(): Observable<any> {
    let panier: Map<string, number> = new Map(
      JSON.parse(localStorage.getItem('panier')!)
    );
    const lignesCommandes: any[] = [];
    panier.forEach((value: number, key: string) => {
      let produit = JSON.parse(key);
      let o = {
        id: { produit: produit },
        quantite: value,
      };
      lignesCommandes.push(o);
    });
    let commande = {
      lignesCommandes: lignesCommandes,
    };
    console.log(commande);
    return this.http.post(
      'http://localhost:8080/eshop/api/commande',
      commande,
      {
        headers: this.httpHeaders,
      }
    );
  }

  private get httpHeaders(): HttpHeaders {
    return new HttpHeaders({
      Authorization: 'Basic ' + sessionStorage.getItem('token'),
      'Content-Type': 'application/json',
    });
  }
}
