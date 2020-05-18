import { Component, OnInit } from '@angular/core';
import { DiceService } from '../dice.module.service';
import { CombatRoomService } from '../../combat/services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';

@Component({
  selector: 'app-dice-master-menu',
  templateUrl: './dice-master-menu.component.html',
  styleUrls: ['./dice-master-menu.component.scss']
})
export class DiceMasterMenuComponent implements OnInit {

  constructor(private combatRoomService: CombatRoomService,
    private diceService: DiceService) {
      
    }

  ngOnInit() {
  }

  rollInitiative(){
    this.combatRoomService.updateCreatures(
      this.diceService.rollInitiativeOfCreatures(this.combatRoomService.getCombatStateValue().creatures)
    );
  }
  rollInitiativeOfLeftPlayers(){
    this.combatRoomService.updateCreatures(
      this.diceService.rollInitiativeOfCreatures(this.combatRoomService.getCombatStateValue().creatures)
    );
  }
}
