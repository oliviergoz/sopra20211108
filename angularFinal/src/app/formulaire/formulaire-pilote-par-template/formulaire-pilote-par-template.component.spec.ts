import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePiloteParTemplateComponent } from './formulaire-pilote-par-template.component';

describe('FormulairePiloteParTemplateComponent', () => {
  let component: FormulairePiloteParTemplateComponent;
  let fixture: ComponentFixture<FormulairePiloteParTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulairePiloteParTemplateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePiloteParTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
