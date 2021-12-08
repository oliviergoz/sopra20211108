import { ValiderComponent } from './../../panier/valider/valider.component';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-formulaire-pilote-par-template',
  templateUrl: './formulaire-pilote-par-template.component.html',
  styleUrls: ['./formulaire-pilote-par-template.component.css'],
})
export class FormulairePiloteParTemplateComponent implements OnInit {
  prenom: string = '';
  nom: string = '';

  constructor() {}

  ngOnInit(): void {}

  valider(monForm: any) {
    console.log(monForm);
    console.log(monForm.controls);
    console.log(monForm.controls['prenomControl']);
    console.log(monForm.controls['prenomControl'].value);
    console.log(monForm.controls['prenomControl'].valid);
  }
}
