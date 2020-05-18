import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';

@Component({
  selector: 'app-character-traits-piece',
  templateUrl: './character-traits-piece.component.html',
  styleUrls: ['./character-traits-piece.component.scss']
})
export class CharacterTraitsPieceComponent implements OnInit {

  @Input()
  private sheet: CharacterSheet;
  constructor() { }

  ngOnInit() {
  }

}
