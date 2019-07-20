import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombatMenuComponent } from './combat-menu.component';

describe('CombatMenuComponent', () => {
  let component: CombatMenuComponent;
  let fixture: ComponentFixture<CombatMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombatMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombatMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
