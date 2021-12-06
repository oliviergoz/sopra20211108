import { ProduitService } from './../services/produit.service';
import { DemoService } from './../services/demo.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  //providers: [{ provide: ProduitService, useClass: ProduitService }],
})
export class HomeComponent implements OnInit {
  constructor(private router: Router, private produitService: ProduitService) {}

  ngOnInit(): void {
    this.produitService.getProduits();
  }

  goProduits() {
    this.router.navigate(['/produits']);
  }

  goParams() {
    this.router.navigate(['/params'], {
      queryParams: { prenom: 'popo', nom: 'pupu' },
    });
  }
}
