import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombatScreenComponent } from './combat-screen.component';

describe('CombatScreenComponent', () => {
  let component: CombatScreenComponent;
  let fixture: ComponentFixture<CombatScreenComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombatScreenComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombatScreenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
