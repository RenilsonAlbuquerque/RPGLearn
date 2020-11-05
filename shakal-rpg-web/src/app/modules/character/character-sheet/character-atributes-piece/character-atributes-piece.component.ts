import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';

@Component({
  selector: 'app-character-atributes-piece',
  templateUrl: './character-atributes-piece.component.html',
  styleUrls: ['./character-atributes-piece.component.scss']
})
export class CharacterAtributesPieceComponent implements OnInit {
  
  @Input()
  public sheet: CharacterSheet;
  constructor() { }

  ngOnInit() {
  }

}
