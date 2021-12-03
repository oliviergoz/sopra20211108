import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-couleur',
  templateUrl: './couleur.component.html',
  styleUrls: ['./couleur.component.css'],
})
export class CouleurComponent implements OnInit {
  couleur: string = '#000000';
  constructor() {}

  ngOnInit(): void {}
}
