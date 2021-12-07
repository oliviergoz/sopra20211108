import { AuthService } from './services/auth.service';
import { LoginComponent } from './login/login.component';
import { EditClientComponent } from './client/edit-client/edit-client.component';
import { ClientComponent } from './client/client/client.component';
import { EditComponent } from './produits/edit/edit.component';
import { ProduitsComponent } from './produits/produits/produits.component';
import { HomeComponent } from './home/home.component';
import { Routes } from '@angular/router';

export const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'produits',
    component: ProduitsComponent,
    canActivate: [AuthService],
  },
  {
    path: 'produits/edit/:id',
    component: EditComponent,
    canActivate: [AuthService],
  },
  {
    path: 'produits/edit',
    component: EditComponent,
    canActivate: [AuthService],
  },
  { path: 'clients', component: ClientComponent, canActivate: [AuthService] },
  {
    path: 'clients/edit/:client',
    component: EditClientComponent,
    canActivate: [AuthService],
  },
  { path: 'clients/edit', component: EditClientComponent },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
];
