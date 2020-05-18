import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterSpellsPieceComponent } from './character-spells-piece.component';

describe('CharacterSpellsPieceComponent', () => {
  let component: CharacterSpellsPieceComponent;
  let fixture: ComponentFixture<CharacterSpellsPieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterSpellsPieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterSpellsPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
