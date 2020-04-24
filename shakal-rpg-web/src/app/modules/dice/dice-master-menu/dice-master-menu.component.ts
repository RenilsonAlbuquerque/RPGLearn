import { Component, OnInit } from '@angular/core';
import { DiceService } from '../dice.module.service';
import { CombatRoomService } from '../../combat/services/combat-room.service';
import { faDice } from '@fortawesome/free-solid-svg-icons';

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
    this.diceService.rollInitiativeOfCreatures(this.combatRoomService.getCombatStateValue().creatures)
  }
}
