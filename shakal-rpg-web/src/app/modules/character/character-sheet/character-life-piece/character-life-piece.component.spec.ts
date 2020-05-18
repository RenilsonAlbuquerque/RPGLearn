import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterLifePieceComponent } from './character-life-piece.component';

describe('CharacterLifePieceComponent', () => {
  let component: CharacterLifePieceComponent;
  let fixture: ComponentFixture<CharacterLifePieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterLifePieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterLifePieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
