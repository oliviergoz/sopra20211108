import { Produit } from './../../model/produit';
import { ProduitService } from 'src/app/services/produit.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css'],
})
export class PanierComponent implements OnInit {
  produits: Produit[] = [];
  panier: Map<string, number> = new Map();
  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.initProduit();
  }

  initProduit() {
    this.produitService.allProduits().subscribe((produits) => {
      this.produits = produits;
      if (!localStorage.getItem('panier')) {
        localStorage.setItem('panier', JSON.stringify([...this.panier]));
      }
      let map: Map<string, number> = new Map(
        JSON.parse(localStorage.getItem('panier')!)
      );
      this.panier = map;
    });
  }

  getQuantite(index: number): number {
    return this.panier.get(JSON.stringify(this.produits[index]))!;
  }

  addPanier(index: number) {
    let produitEnString = JSON.stringify(this.produits[index]);
    let map: Map<string, number> = new Map(
      JSON.parse(localStorage.getItem('panier')!)
    );
    map.set(produitEnString, (map.get(produitEnString) ?? 0) + 1);
    this.panier = map;
    localStorage.setItem('panier', JSON.stringify([...this.panier]));
  }

  remove(produit: Produit) {
    let produitEnString = JSON.stringify(produit);
    let map: Map<string, number> = new Map(
      JSON.parse(localStorage.getItem('panier')!)
    );
    if (map.get(produitEnString) !== 1) {
      map.set(produitEnString, (map.get(produitEnString) ?? 0) - 1);
    } else {
      map.delete(produitEnString);
    }
    this.panier = map;
    localStorage.setItem('panier', JSON.stringify([...this.panier]));
  }
}
