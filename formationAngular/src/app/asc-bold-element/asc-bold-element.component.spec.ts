import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AscBoldElementComponent } from './asc-bold-element.component';

describe('AscBoldElementComponent', () => {
  let component: AscBoldElementComponent;
  let fixture: ComponentFixture<AscBoldElementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AscBoldElementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AscBoldElementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
