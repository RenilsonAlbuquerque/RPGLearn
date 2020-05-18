import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';

@Component({
  selector: 'app-character-spells-piece',
  templateUrl: './character-spells-piece.component.html',
  styleUrls: ['./character-spells-piece.component.scss']
})
export class CharacterSpellsPieceComponent implements OnInit {

  @Input()
  private sheet: CharacterSheet;
  constructor() { }

  ngOnInit() {
  }

}
