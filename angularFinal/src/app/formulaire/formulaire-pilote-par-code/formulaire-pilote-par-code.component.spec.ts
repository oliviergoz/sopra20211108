import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormulairePiloteParCodeComponent } from './formulaire-pilote-par-code.component';

describe('FormulairePiloteParCodeComponent', () => {
  let component: FormulairePiloteParCodeComponent;
  let fixture: ComponentFixture<FormulairePiloteParCodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormulairePiloteParCodeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormulairePiloteParCodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
