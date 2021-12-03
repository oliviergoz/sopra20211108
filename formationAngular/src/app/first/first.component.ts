import { Personne } from './../model/personne';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  message = 'hello world';
  olivier: Personne = new Personne('olivier', 'gozlan');

  couleur = 'Red';
  constructor() {}

  ngOnInit(): void {}

  actionBouton() {
    //alert('on a clique');
    console.log('on a clique');
    this.couleur = 'Yellow';
  }
}
