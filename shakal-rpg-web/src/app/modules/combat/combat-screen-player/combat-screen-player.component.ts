import { Component, OnInit } from '@angular/core';
import { CombatRoomService } from '../services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-combat-screen-player',
  templateUrl: './combat-screen-player.component.html',
  styleUrls: ['./combat-screen-player.component.scss']
})
export class CombatScreenPlayerComponent implements OnInit {

  private combatState: CombatState;
  private storyId: number;
  constructor(private combatRoomService: CombatRoomService,private _activatedRoute: ActivatedRoute) {  
    this.combatRoomService.getCombatState().subscribe(
      state => {this.combatState = state;
      console.log(this.combatState);}
    );
  }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyId = params['id'];
      this.combatRoomService.initializeCombat(this.storyId);
    });
    
  }

}
