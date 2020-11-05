import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';

@Component({
  selector: 'app-character-life-piece',
  templateUrl: './character-life-piece.component.html',
  styleUrls: ['./character-life-piece.component.scss']
})
export class CharacterLifePieceComponent implements OnInit {

  @Input()
  public sheet: CharacterSheet;
  constructor() { }

  ngOnInit() {
  }

}
