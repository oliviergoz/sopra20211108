import { Directive, ElementRef, Renderer2, OnInit, Input } from '@angular/core';

@Directive({
  selector: '[appExempleCreationElement]',
})
export class ExempleCreationElementDirective implements OnInit {
  @Input()
  message: string = '';

  constructor(private el: ElementRef, private renderer: Renderer2) {}

  ngOnInit() {
    const p = this.renderer.createElement('p');
    const text = this.renderer.createText(
      'du texte cree pas la directive et le message recu:' + this.message
    );
    this.renderer.appendChild(p, text);
    this.renderer.appendChild(this.el.nativeElement, p);
  }
}
