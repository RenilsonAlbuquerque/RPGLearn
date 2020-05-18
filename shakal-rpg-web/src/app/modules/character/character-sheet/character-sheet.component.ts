import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { CharacterService } from '../character.module.service';
import { initializeCharacterSheet } from 'src/app/domain/mappers/character.mapper';

@Component({
  selector: 'app-character-sheet',
  //templateUrl: './character-sheet.component.html',
  templateUrl: './character.html',
  //styleUrls: ['./character-sheet.component.scss']
  styleUrls: ['./character.sheet.alt.scss']
})
export class CharacterSheetComponent implements OnInit {
  private hpLife: boolean =true;
  private abilities: boolean =false;
  private item: boolean =false;

  @Input() characterId: number;
  private sheet: CharacterSheet;

  public mobile: boolean = true;
  constructor(private characterService: CharacterService) {
    this.sheet = initializeCharacterSheet();
  }

  ngOnInit() {
    this.characterService.getCharacterSheet(this.characterId).subscribe(
      response => (
        console.log(response),
        this.sheet = response)  
    )
    if (window.innerWidth <= 400) { // 768px portrait
      this.mobile = true;
    }
  }
  handleAbilities(){
    this.abilities = true;
    this.hpLife = false;
    this.item = false;
  }
  handleAc(){
    this.abilities = false;
    this.hpLife = true;
    this.item = false;
  }
  handleItem(){
    this.abilities = false;
    this.hpLife = false;
    this.item = true;
  }

}
