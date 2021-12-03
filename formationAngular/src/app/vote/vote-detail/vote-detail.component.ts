import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';

@Component({
  selector: 'app-vote-detail',
  templateUrl: './vote-detail.component.html',
  styleUrls: ['./vote-detail.component.css'],
})
export class VoteDetailComponent implements OnInit {
  @Input('candidat')
  texte: string = '';
  @Output('vote')
  vote: EventEmitter<Object> = new EventEmitter();
  compteur: number = 0;

  constructor() {}

  ngOnInit(): void {}

  voter() {
    this.compteur++;
    this.vote.emit({ candidat: this.texte, compteur: this.compteur });
  }
}
