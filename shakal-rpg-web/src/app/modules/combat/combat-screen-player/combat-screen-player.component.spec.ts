import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CombatScreenPlayerComponent } from './combat-screen-player.component';

describe('CombatScreenPlayerComponent', () => {
  let component: CombatScreenPlayerComponent;
  let fixture: ComponentFixture<CombatScreenPlayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CombatScreenPlayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CombatScreenPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
