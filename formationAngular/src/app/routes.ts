import { CouleurComponent } from './couleur/couleur.component';
import { FormProduitComponent } from './produit/form-produit/form-produit.component';
import { ParamsComponent } from './params/params.component';
import { ProduitsComponent } from './produit/produits/produits.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: 'produits/edit/:index', component: FormProduitComponent },
  { path: 'produits/edit', component: FormProduitComponent },
  { path: 'params/prenom/:prenom/nom/:nom', component: ParamsComponent },
  { path: 'params', component: ParamsComponent },
  { path: 'couleur', component: CouleurComponent, outlet: 'autreOutlet' },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
