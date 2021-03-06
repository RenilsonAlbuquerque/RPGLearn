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
  public hpLife: boolean =true;
  public abilities: boolean =false;
  public item: boolean =false;
  public trait: boolean =false;
  public spell: boolean =false;

  @Input() characterId: number;
  public sheet: CharacterSheet;

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
    this.trait = false;
    this.spell = false;
  }
  handleAc(){
    this.abilities = false;
    this.hpLife = true;
    this.item = false;
    this.trait = false;
    this.spell = false;
  }
  handleItem(){
    this.abilities = false;
    this.hpLife = false;
    this.item = true;
    this.trait = false;
    this.spell = false;
  }
  handleTrait(){
    this.abilities = false;
    this.hpLife = false;
    this.item = false;
    this.trait = true;
    this.spell = false;
  }
  handleSpell(){
    this.abilities = false;
    this.hpLife = false;
    this.item = false;
    this.trait = false;
    this.spell = true;
  }
  /*############# Swipe #####################*/
  onSwipeLeft(event){
    if(this.hpLife){
      this.hpLife = false;
      this.abilities =true;
      return;
    }
    if(this.abilities){
      this.abilities = false;
      this.item = true;
      return;
    }
    if(this.item){
      this.item = false;
      this.trait = true;
      return;
    }
    if(this.trait){
      this.trait = false;
      this.spell = true;
      return;
    }
    if(this.spell){
      this.spell = false;
      this.hpLife = true;
      return;
    }
  }
  onSwipeRight(event){
    if(this.hpLife){
      this.hpLife = false;
      this.spell =true;
      return;
    }
    if(this.abilities){
      this.abilities = false;
      this.hpLife = true;
      return;
    }
    if(this.item){
      this.item = false;
      this.abilities = true;
      return;
    }
    if(this.trait){
      this.trait = false;
      this.item = true;
      return;
    }
    if(this.spell){
      this.spell = false;
      this.trait = true;
      return;
    }
  }
}
