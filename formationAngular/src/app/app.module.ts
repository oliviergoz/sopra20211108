import { routes } from './routes';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FirstComponent } from './first/first.component';
import { FormsModule } from '@angular/forms';
import { CouleurComponent } from './couleur/couleur.component';
import { ProduitComponent } from './produit/produit.component';
import { TestSelectorComponent } from './test-selector/test-selector.component';
import { AscBoldElementComponent } from './asc-bold-element/asc-bold-element.component';
import { AscTooltipComponent } from './asc-tooltip/asc-tooltip.component';
import { OutputComponent } from './output/output.component';
import { FormProduitComponent } from './produit/form-produit/form-produit.component';
import { DisplayProduitComponent } from './produit/display-produit/display-produit.component';
import { VoteDetailComponent } from './vote/vote-detail/vote-detail.component';
import { VoteComponent } from './vote/vote/vote.component';
import { ProduitsComponent } from './produit/produits/produits.component';
import { TestDirective } from './directive/test.directive';
import { ExempleCreationElementDirective } from './directive/exemple-creation-element.directive';
import { HomeComponent } from './home/home.component';
import { ParamsComponent } from './params/params.component';
import { DemoPipe } from './pipes/demo.pipe';
import { ProduitService } from './services/produit.service';


@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    CouleurComponent,
    ProduitComponent,
    TestSelectorComponent,
    AscBoldElementComponent,
    AscTooltipComponent,
    OutputComponent,
    FormProduitComponent,
    DisplayProduitComponent,
    VoteDetailComponent,
    VoteComponent,
    ProduitsComponent,
    TestDirective,
    ExempleCreationElementDirective,
    HomeComponent,
    ParamsComponent,
    DemoPipe,
  ],
  imports: [BrowserModule, FormsModule, RouterModule.forRoot(routes)],
  providers: [[{ provide: ProduitService, useClass: ProduitService }]],
  bootstrap: [AppComponent],
})
export class AppModule {}
