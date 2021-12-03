import { Produit } from './../model/produit';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produit',
  templateUrl: './produit.component.html',
  styleUrls: ['./produit.component.css'],
})
export class ProduitComponent implements OnInit {
  produit: Produit = new Produit();
  constructor() {}

  ngOnInit(): void {}

  getProduit(produit: Produit) {
    this.produit = produit;
  }
}
