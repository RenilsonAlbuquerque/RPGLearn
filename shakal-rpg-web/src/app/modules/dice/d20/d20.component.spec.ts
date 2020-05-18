import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { D20Component } from './d20.component';

describe('D20Component', () => {
  let component: D20Component;
  let fixture: ComponentFixture<D20Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ D20Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(D20Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
