import { Component, OnInit } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryService } from '../story.module.service';
import { CharacterService } from '../../character/character.module.service';
import { StoryRoomPlayerService } from '../story-room-player.service';
import { AuthService } from 'src/app/pages/auth.service';
import { CombatRoomService } from '../../combat/services/combat-room.service';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { Level } from 'src/app/domain/models/comon/level';
import { CombatState } from 'src/app/domain/models/combat/combat.state';

@Component({
  selector: 'app-story-detail-player',
  templateUrl: './story-detail-player.component.html',
  styleUrls: ['./story-detail-player.component.scss']
})
export class StoryDetailPlayerComponent implements OnInit {

  private combatShown: boolean;
  private mapShown: boolean;
  private storyId: number;
  private combatState: CombatState;

  constructor(private _activatedRoute: ActivatedRoute, private characterService: CharacterService,
    private router: Router, private authService: AuthService, private combatRoomService:CombatRoomService) {
      
    this._activatedRoute.params.subscribe(params => {
      this.storyId = params['id'];
      this.characterService.getCharacterSheetOnStory(this.storyId,this.authService.getCurrentUser().id).subscribe(
        data => {
          this.combatRoomService.getCombatState().subscribe(
            state => {this.combatState = state,
              this.initializePlayerInformations(data)
            }); 
        },
        err =>{
          this.redirectCreateSheet();
        }
      );
    });
    this.combatShown = true;
    this.mapShown = false;
   }

  ngOnInit() {
  }
  onShowCombat(){
    this.combatShown = true;
    this.mapShown = false;
  }
  onShowMap(){
    this.combatShown = false;
    this.mapShown = true;
  }
  redirectCreateSheet(){
    this.router.navigate(['home/character/create-in-story/'+ this.storyId]);
  }
  initializePlayerInformations(characterSheet: CharacterSheet){
    this.combatRoomService.addMonsterAlly({
      id: characterSheet.id,
      name: characterSheet.name,
      level: {id: 1, value:1, xp:500} as Level,
      lifePoints: characterSheet.lifePoints,
      totalLifePoints: characterSheet.totalLifePoints,
      imagePath: characterSheet.imagePath,
      lifePercent: (100 *characterSheet.lifePoints)/ characterSheet.totalLifePoints,
      position: {x: 4, y:5}
    } as MonsterCard);
    // this.combatRoomService.getCombatState().subscribe(
    //   data => data.players.push({
    //     id: characterSheet.id,
    //     name: characterSheet.name,
    //     level: {id: 1, value:1, xp:500} as Level,
    //     lifePoints: characterSheet.lifePoints,
    //     totalLifePoints: characterSheet.totalLifePoints,
    //     imagePath: characterSheet.imagePath,
    //     lifePercent: (100 *characterSheet.lifePoints)/ characterSheet.totalLifePoints,
    //     position: {x: 4, y:5}
    //   } as MonsterCard)
    // )
  }

}
