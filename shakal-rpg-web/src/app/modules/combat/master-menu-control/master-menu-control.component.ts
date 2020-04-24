import { Component, OnInit } from '@angular/core';
import { CombatRoomService } from '../services/combat-room.service';
import { DiceService } from '../../dice/dice.module.service';

@Component({
  selector: 'app-master-menu-control',
  templateUrl: './master-menu-control.component.html',
  styleUrls: ['./master-menu-control.component.scss']
})
export class MasterMenuControlComponent implements OnInit {

  constructor(private combatRoomService: CombatRoomService,
    private diceService: DiceService) { }

  ngOnInit() {
  }
  openMenu(){
    document.getElementById("sidebar-master").style.width = "250px";
    
  }
  disable(){
    document.getElementById("sidebar-master").style.width = "0";
  }
  rollInitiative(){
    document.getElementById("sidebar-master").style.width = "0";
    this.diceService.rollInitiativeOfCreatures(this.combatRoomService.getCombatStateValue().creatures)
      
    
    
  }

}
