import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiceRollContainerComponent } from './dice-roll-container.component';

describe('DiceRollContainerComponent', () => {
  let component: DiceRollContainerComponent;
  let fixture: ComponentFixture<DiceRollContainerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiceRollContainerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiceRollContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
