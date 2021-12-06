import { Component, HostListener, Input, OnInit } from '@angular/core';

@Component({
  selector: 'asc-bold-element',
  templateUrl: './asc-bold-element.component.html',
  styleUrls: ['./asc-bold-element.component.css'],
})
export class AscBoldElementComponent implements OnInit {
  @Input()
  prefix: string = '';
  @Input()
  text: string = '';

  constructor() {}

  ngOnInit(): void {}

  @HostListener('click')
  showAlert() {
    alert(this.text);
  }
}
