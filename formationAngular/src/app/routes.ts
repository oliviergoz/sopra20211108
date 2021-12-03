import { ParamsComponent } from './params/params.component';
import { ProduitsComponent } from './produit/produits/produits.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: 'params/prenom/:prenom/nom/:nom', component: ParamsComponent },
  { path: 'params', component: ParamsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
