import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProduitsComponent } from './produits/produits/produits.component';
import { routes } from './routes';
import { EditComponent } from './produits/edit/edit.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClientComponent } from './client/client/client.component';
import { EditClientComponent } from './client/edit-client/edit-client.component';
import { LoginComponent } from './login/login.component';
import { PanierComponent } from './panier/panier/panier.component';
import { RecapComponent } from './panier/recap/recap.component';
import { ValiderComponent } from './panier/valider/valider.component';
import { FormulairePiloteParTemplateComponent } from './formulaire/formulaire-pilote-par-template/formulaire-pilote-par-template.component';
import { FormulairePiloteParCodeComponent } from './formulaire/formulaire-pilote-par-code/formulaire-pilote-par-code.component';
import { InscriptionComponent } from './client/inscription/inscription.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProduitsComponent,
    EditComponent,
    ClientComponent,
    EditClientComponent,
    LoginComponent,
    PanierComponent,
    RecapComponent,
    ValiderComponent,
    FormulairePiloteParTemplateComponent,
    FormulairePiloteParCodeComponent,
    InscriptionComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
