import { ActivatedRoute, Router } from '@angular/router';
import { Produit } from './../../model/produit';
import {
  AfterContentChecked,
  ChangeDetectorRef,
  Component,
  OnInit,
} from '@angular/core';

@Component({
  selector: 'app-recap',
  templateUrl: './recap.component.html',
  styleUrls: ['./recap.component.css'],
})
export class RecapComponent implements OnInit, AfterContentChecked {
  panier: Map<string, number> = new Map();
  produits: Produit[] = [];
  total: number = 0;

  constructor(
    private changeDetector: ChangeDetectorRef,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.panier = new Map(JSON.parse(localStorage.getItem('panier')!));
    this.panier.forEach((value: number, key: string) => {
      this.produits.push(JSON.parse(key));
    });
  }

  getQuantite(produit: Produit): number {
    return this.panier.get(JSON.stringify(produit))!;
  }
  getPrix(produit: Produit): number {
    let prixTotal = this.panier.get(JSON.stringify(produit))! * produit.prix!;
    this.total += prixTotal;
    return prixTotal;
  }

  getTotal() {
    return this.total;
  }
  ngAfterContentChecked(): void {
    this.changeDetector.detectChanges();
  }

  goValider() {
    localStorage.setItem('valider', 'valider');
    this.router.navigate(['/valider']);
  }
}
