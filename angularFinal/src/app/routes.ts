import { EditClientComponent } from './client/edit-client/edit-client.component';
import { ClientComponent } from './client/client/client.component';
import { EditComponent } from './produits/edit/edit.component';
import { ProduitsComponent } from './produits/produits/produits.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'produits', component: ProduitsComponent },
  { path: 'produits/edit/:id', component: EditComponent },
  { path: 'produits/edit', component: EditComponent },
  { path: 'clients', component: ClientComponent },
  { path: 'clients/edit/:client', component: EditClientComponent },
  { path: 'clients/edit', component: EditClientComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
