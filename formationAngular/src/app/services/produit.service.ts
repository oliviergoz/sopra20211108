import { Produit } from './../model/produit';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ProduitService {
  constructor() {}
  public getProduits(): Produit[] {
    console.log('getProduit de ProduitService');
    return [];
  }
}
