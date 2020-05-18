import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombatCounterComponent } from './combat-counter.component';

describe('CombatCounterComponent', () => {
  let component: CombatCounterComponent;
  let fixture: ComponentFixture<CombatCounterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombatCounterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombatCounterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
