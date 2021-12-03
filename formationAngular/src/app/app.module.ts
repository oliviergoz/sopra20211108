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

@NgModule({
  declarations: [AppComponent, FirstComponent, CouleurComponent, ProduitComponent, TestSelectorComponent, AscBoldElementComponent, AscTooltipComponent, OutputComponent, FormProduitComponent, DisplayProduitComponent],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
