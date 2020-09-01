import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceListCardComponent } from './place-list-card.component';

describe('PlaceListCardComponent', () => {
  let component: PlaceListCardComponent;
  let fixture: ComponentFixture<PlaceListCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaceListCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaceListCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
