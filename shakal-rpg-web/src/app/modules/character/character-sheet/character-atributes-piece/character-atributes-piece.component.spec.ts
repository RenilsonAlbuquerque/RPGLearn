import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterAtributesPieceComponent } from './character-atributes-piece.component';

describe('CharacterAtributesPieceComponent', () => {
  let component: CharacterAtributesPieceComponent;
  let fixture: ComponentFixture<CharacterAtributesPieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterAtributesPieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterAtributesPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
