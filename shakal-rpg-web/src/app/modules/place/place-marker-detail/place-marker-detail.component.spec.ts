import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaceMarkerDetailComponent } from './place-marker-detail.component';

describe('PlaceMarkerDetailComponent', () => {
  let component: PlaceMarkerDetailComponent;
  let fixture: ComponentFixture<PlaceMarkerDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlaceMarkerDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaceMarkerDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
