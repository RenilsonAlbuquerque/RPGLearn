import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterItemPieceComponent } from './character-item-piece.component';

describe('CharacterItemPieceComponent', () => {
  let component: CharacterItemPieceComponent;
  let fixture: ComponentFixture<CharacterItemPieceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CharacterItemPieceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CharacterItemPieceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
