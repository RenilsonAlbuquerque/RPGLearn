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
import { CombatRoomPlayerService } from '../../combat/services/combat-room.player.service';

@Component({
  selector: 'app-story-detail-player',
  templateUrl: './story-detail-player.component.html',
  styleUrls: ['./story-detail-player.component.scss']
})
export class StoryDetailPlayerComponent implements OnInit {

  private combatShown: boolean;
  private mapShown: boolean;
  private storyId: number;

  constructor(private _activatedRoute: ActivatedRoute, private characterService: CharacterService,
    private router: Router, private authService: AuthService, private combatRoomPlayerService:CombatRoomPlayerService) {
      
    this._activatedRoute.params.subscribe(params => {
      this.storyId = params['id'];
      this.combatRoomPlayerService.initializeCombat(this.storyId);
      this.characterService.getCharacterSheetOnStory(this.storyId,this.authService.getCurrentUser().id).subscribe(
        data => {
          this.combatRoomPlayerService.initializePlayerInfo(data, authService.getCurrentUser().id)
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
}
