import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterTraitsPieceComponent } from './character-traits-piece.component';

describe('CharacterTraitsPieceComponent', () => {
  let component: CharacterTraitsPieceComponent;
  let fixture: ComponentFixture<CharacterTraitsPieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterTraitsPieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterTraitsPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
