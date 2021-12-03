import { Produit } from './../../model/produit';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-display-produit',
  templateUrl: './display-produit.component.html',
  styleUrls: ['./display-produit.component.css'],
})
export class DisplayProduitComponent implements OnInit {
  @Input()
  produit: Produit = new Produit();

  constructor() {}

  ngOnInit(): void {}
}
