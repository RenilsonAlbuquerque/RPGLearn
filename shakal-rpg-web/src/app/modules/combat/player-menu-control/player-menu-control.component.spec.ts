import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerMenuControlComponent } from './player-menu-control.component';

describe('PlayerMenuControlComponent', () => {
  let component: PlayerMenuControlComponent;
  let fixture: ComponentFixture<PlayerMenuControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerMenuControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerMenuControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
