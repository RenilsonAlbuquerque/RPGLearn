import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { D8Component } from './d8.component';

describe('D8Component', () => {
  let component: D8Component;
  let fixture: ComponentFixture<D8Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ D8Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(D8Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
