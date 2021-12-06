import { Produit } from './../../model/produit';
import { ProduitService } from 'src/app/services/produit.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css'],
})
export class EditComponent implements OnInit {
  produit: Produit = new Produit();

  constructor(
    private activatedRoute: ActivatedRoute,
    private produitService: ProduitService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.activatedRoute.params.subscribe((params) => {
      if (!!params['id']) {
        this.produitService.getById(params['id']).subscribe((result) => {
          this.produit = result;
          console.log(result);
        });
      }
    });
  }

  save() {
    if (!!this.produit.id) {
      this.produitService.update(this.produit).subscribe((result) => {
        this.goList();
      });
    } else {
      this.produitService.insert(this.produit).subscribe((result) => {
        this.goList();
      });
    }
  }

  goList() {
    this.router.navigate(['/produits']);
  }
}
