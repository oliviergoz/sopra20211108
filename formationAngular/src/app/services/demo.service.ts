import { Produit } from './../model/produit';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DemoService {
  constructor() {
    console.log('instanciation du service');
  }

  public methodeDuService() {
    console.log('methode du service');
  }

  public getProduits(): Produit[] {
    console.log('getProduit de DEmoService');
    return [new Produit('tele', 1000), new Produit('telephone', 500)];
  }
}
