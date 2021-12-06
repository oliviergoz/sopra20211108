import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vote',
  templateUrl: './vote.component.html',
  styleUrls: ['./vote.component.css'],
})
export class VoteComponent implements OnInit {
  candidat: string = '';
  max: number = 0;
  constructor() {}

  ngOnInit(): void {}

  traitementVote(o: any) {
    if (this.max < o.compteur) {
      this.candidat = o.candidat;
      this.max = o.compteur;
    }
  }
}
