import { Component, OnInit } from '@angular/core';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';
import { CombatRoomPlayerService } from '../services/combat-room.player.service';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';

@Component({
  selector: 'app-combat-screen-player',
  templateUrl: './combat-screen-player.component.html',
  styleUrls: ['./combat-screen-player.component.scss']
})
export class CombatScreenPlayerComponent implements OnInit {

  public combatState: CombatState;
  private storyId: number;
  constructor(private combatRoomPlayerService: CombatRoomService,private _activatedRoute: ActivatedRoute,
    private gridBoardService:GridBoardService) {  
    this.combatRoomPlayerService.getCombatState().subscribe(
      state => {this.combatState = state;}
    );
  }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyId = params['id'];
      this.combatRoomPlayerService.initializeCombat(this.storyId);
      this.combatRoomPlayerService.loadCombatState(this.storyId).subscribe(
        result => {
          this.combatRoomPlayerService.updateCombateState(result);
          this.gridBoardService.updateMapById(result.placeId);
        }
      );
    });
    // this._activatedRoute.params.subscribe(params => {
    //   this.storyId = params['id'];
    //   this.combatRoomPlayerService.initializeCombat(this.storyId);
    // });
    
  }

}
