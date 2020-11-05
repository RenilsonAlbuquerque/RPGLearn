import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterService } from '../../character/character.module.service';
import { AuthService } from 'src/app/pages/auth.service';
import { CombatRoomPlayerService } from '../../combat/services/combat-room.player.service';

@Component({
  selector: 'app-story-detail-player',
  templateUrl: './story-detail-player.component.html',
  styleUrls: ['./story-detail-player.component.scss']
})
export class StoryDetailPlayerComponent implements OnInit {

  public combatShown: boolean;
  public mapShown: boolean;
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
