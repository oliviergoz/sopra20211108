import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ProduitsComponent } from './produits/produits/produits.component';
import { routes } from './routes';

@NgModule({
  declarations: [AppComponent, HomeComponent, ProduitsComponent],
  imports: [BrowserModule, RouterModule.forRoot(routes), HttpClientModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
