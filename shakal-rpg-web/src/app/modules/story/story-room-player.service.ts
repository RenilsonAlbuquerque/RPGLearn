import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';

import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';

@Injectable()
export class StoryRoomPlayerService {

  private storyId: number;
  private characterSheet: CharacterSheet;
  
  constructor(private httpClient: HttpClient) {
     
  }
  getStoryId(): number{
    return this.storyId;
  }
  getCharacterSheet():CharacterSheet{
    return this.characterSheet;
  }
  setStoryId(storyId: number): void{
    this.storyId = storyId;;
  }
  setCharacterSheet(characterSheet: CharacterSheet):void{
    this.characterSheet = characterSheet;
  }
  
}