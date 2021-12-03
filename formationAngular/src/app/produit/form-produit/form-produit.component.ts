import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Produit } from 'src/app/model/produit';

@Component({
  selector: 'app-form-produit',
  templateUrl: './form-produit.component.html',
  styleUrls: ['./form-produit.component.css'],
})
export class FormProduitComponent implements OnInit {
  produit: Produit = new Produit();

  @Output('produitEvent')
  produitEvent: EventEmitter<Produit> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  send() {
    this.produitEvent.emit(this.produit);
    this.produit = new Produit();
  }
}
