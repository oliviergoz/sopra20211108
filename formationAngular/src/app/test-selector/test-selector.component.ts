import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-test-selector,[directive-test-selector]',
  templateUrl: './test-selector.component.html',
  styleUrls: ['./test-selector.component.css'],
})
export class TestSelectorComponent implements OnInit {
  @Input('unMessage')
  message: string = '';

  constructor() {}

  ngOnInit(): void {}
}
