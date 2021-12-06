import { allProduits } from './../../produits';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent implements OnInit {
  produit: Produit = new Produit();

  index: number = -1;

  // @Output('produitEvent')
  // produitEvent: EventEmitter<Produit> = new EventEmitter();

  constructor(private aR: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.aR.params.subscribe((params) => {
      if (!!params.index) {
        this.produit = allProduits[params.index];
        this.index = params.index;
      }
    });
  }

  send() {
    // this.produitEvent.emit(this.produit);
    // this.produit = new Produit();
    if (this.index != -1) {
      allProduits[this.index] = this.produit;
    } else {
      allProduits.push(this.produit);
    }
    this.router.navigate(['/produits']);
  }
}
