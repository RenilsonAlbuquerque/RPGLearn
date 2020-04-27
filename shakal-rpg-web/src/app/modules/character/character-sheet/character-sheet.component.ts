import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { CharacterService } from '../character.module.service';

@Component({
  selector: 'app-character-sheet',
  templateUrl: './character-sheet.component.html',
  styleUrls: ['./character-sheet.component.scss']
})
export class CharacterSheetComponent implements OnInit {

  @Input() characterId: number;
  private sheet: CharacterSheet;
  constructor(private characterService: CharacterService) {
    this.sheet = {} as CharacterSheet;
  }

  ngOnInit() {
    this.characterService.getCharacterSheet(this.characterId).subscribe(
      response => (this.sheet = response)  
    )
  }

}
