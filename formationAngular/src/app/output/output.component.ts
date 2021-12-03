import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-output',
  templateUrl: './output.component.html',
  styleUrls: ['./output.component.css'],
})
export class OutputComponent implements OnInit {
  @Output('outputEvent')
  sortie: EventEmitter<string> = new EventEmitter();

  constructor() {}

  ngOnInit(): void {}

  declenchementDeLEvenemventOutPutEvent() {
    this.sortie.emit('hello du component output');
  }
}
