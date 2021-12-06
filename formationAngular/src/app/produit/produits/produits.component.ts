import { allProduits } from './../../produits';
import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
})
export class ProduitsComponent implements OnInit {
  produits: Produit[] = allProduits;

  chaine: string = '';

  constructor() {}

  ngOnInit(): void {}

  info(produit: Produit): string {
    if (produit.prix < 0) {
      return 'negatif';
    } else if (produit.prix == 0) {
      return 'neutre';
    } else {
      return 'positif';
    }
  }
  addProduit(produit: Produit) {
    this.produits.push(produit);
  }

  filtre(): Produit[] {
    return this.produits.filter((p) => {
      return p.nom.indexOf(this.chaine) !== -1;
    });
  }

  delete(index:number){
    this.produits.splice(index,1);
  }
}
