import { Component, OnInit } from '@angular/core';
import { CombatRoomService } from '../services/combat-room.service';
import { DiceService } from '../../dice/dice.module.service';

@Component({
  selector: 'app-master-menu-control',
  templateUrl: './master-menu-control.component.html',
  styleUrls: ['./master-menu-control.component.scss']
})
export class MasterMenuControlComponent implements OnInit {

  private creatureMenu: boolean;
  private diceMenu: boolean;
  private configMenu: boolean;
  constructor() { 
    this.diceMenu = true;
    this.creatureMenu = false;
    this.configMenu = false;
  }

  ngOnInit() {
  }
  openMenu(){
    document.getElementById("sidebar-master").style.width = "250px";
  }
  disable(){
    document.getElementById("sidebar-master").style.width = "0";
  }
 
  openDiceMenu(){
    this.creatureMenu = false;
    this.diceMenu = true;
  }
  openCreatureMenu(){
    this.creatureMenu = true;
    this.diceMenu = false;
  }

}