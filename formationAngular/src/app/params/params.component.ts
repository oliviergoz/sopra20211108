import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-params',
  templateUrl: './params.component.html',
  styleUrls: ['./params.component.css'],
})
export class ParamsComponent implements OnInit {
  personne: Personne = new Personne();

  constructor(private activatedRoute: ActivatedRoute) {
    //assynchrone
  }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe((params: any) => {
      if (!!params.prenom && !!params.nom) {
        this.personne = new Personne(params.prenom, params.nom);
      }
    });

    this.activatedRoute.params.subscribe((params: any) => {
      if (!!params.prenom && !!params.nom) {
        console.log('pathvariable');
        this.personne = new Personne(params.prenom, params.nom);
      }
    });
  }
}
