import { Component, OnInit } from '@angular/core';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';
import { CombatRoomPlayerService } from '../services/combat-room.player.service';

@Component({
  selector: 'app-combat-screen-player',
  templateUrl: './combat-screen-player.component.html',
  styleUrls: ['./combat-screen-player.component.scss']
})
export class CombatScreenPlayerComponent implements OnInit {

  private combatState: CombatState;
  private storyId: number;
  constructor(private combatRoomPlayerService: CombatRoomPlayerService,private _activatedRoute: ActivatedRoute) {  
    this.combatRoomPlayerService.getCombatState().subscribe(
      state => {this.combatState = state;}
    );
  }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyId = params['id'];
      this.combatRoomPlayerService.initializeCombat(this.storyId);
    });
    
  }

}
