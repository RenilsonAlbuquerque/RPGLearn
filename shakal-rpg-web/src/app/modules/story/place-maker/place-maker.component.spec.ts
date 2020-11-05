import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceMakerComponent } from './place-maker.component';

describe('PlaceMakerComponent', () => {
  let component: PlaceMakerComponent;
  let fixture: ComponentFixture<PlaceMakerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaceMakerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaceMakerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
