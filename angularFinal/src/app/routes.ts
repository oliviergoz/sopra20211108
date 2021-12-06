import { ProduitsComponent } from './produits/produits/produits.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
