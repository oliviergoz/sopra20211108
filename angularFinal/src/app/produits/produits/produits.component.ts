import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
})
export class ProduitsComponent implements OnInit {
  produits = [];

  constructor(private produitService: ProduitService) {}

  ngOnInit(): void {
    this.produitService.allProduits().subscribe((result) => {
      this.produits = result;
      console.log(this.produits);
    });
  }
}
