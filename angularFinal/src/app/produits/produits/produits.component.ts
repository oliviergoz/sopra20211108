import { Produit } from './../../model/produit';
import { Component, OnInit } from '@angular/core';
import { ProduitService } from 'src/app/services/produit.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-produits',
  templateUrl: './produits.component.html',
  styleUrls: ['./produits.component.css'],
})
export class ProduitsComponent implements OnInit {
  //produits:Produit[] = [];
  produits: Observable<Produit[]> | undefined = undefined;

  constructor(private produitService: ProduitService) {
    //this.produits = this.produitService.allProduits();
  }

  ngOnInit(): void {
    // this.produitService.allProduits().subscribe((result) => {
    //   this.produits = result;
    //   console.log(this.produits);
    // },error=>{
    //   console.log(error);
    // });

    this.produits = this.produitService.allProduits();
  }

  delete(id: number | undefined) {
    if (!!id) {
      this.produitService.delete(id).subscribe((result) => {
        this.produits = this.produitService.allProduits();
      });
    }
  }
}
