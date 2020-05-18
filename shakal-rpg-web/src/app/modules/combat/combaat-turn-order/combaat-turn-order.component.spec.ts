import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombaatTurnOrderComponent } from './combaat-turn-order.component';

describe('CombaatTurnOrderComponent', () => {
  let component: CombaatTurnOrderComponent;
  let fixture: ComponentFixture<CombaatTurnOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombaatTurnOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombaatTurnOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
