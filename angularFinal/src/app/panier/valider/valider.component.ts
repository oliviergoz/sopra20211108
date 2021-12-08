import { ValiderService } from './../../services/valider.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-valider',
  templateUrl: './valider.component.html',
  styleUrls: ['./valider.component.css'],
})
export class ValiderComponent implements OnInit {
  constructor(private validerService: ValiderService) {}

  ngOnInit(): void {
    this.validerService.enregistrer().subscribe((ok) => {
      console.log(ok);
    });
  }
}
