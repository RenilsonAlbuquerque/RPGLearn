import { Component, OnInit } from '@angular/core';
import { CombatRoomService } from '../services/combat-room.service';
import { DiceService } from '../../dice/dice.module.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-master-menu-control',
  templateUrl: './master-menu-control.component.html',
  styleUrls: ['./master-menu-control.component.scss']
})
export class MasterMenuControlComponent implements OnInit {

  private creatureMenu: boolean;
  private diceMenu: boolean;
  private configMenu: boolean;
  private modalReference;
  constructor(private combatRoomService:CombatRoomService,private modalService: NgbModal,
    private diceService: DiceService) { 
    this.diceMenu = true;
    this.creatureMenu = false;
    this.configMenu = false;
  }

  ngOnInit() {
  }
  get canStartCombat(): boolean{
    if(this.combatRoomService.getCombatStateValue().creatures.length > 0
    && !this.combatRoomService.getCombatStateValue().combatStarted){
      return true;
    }
    return false;
  }
  get thereArePlayersNoInitiated(): boolean{
    if(this.combatRoomService.getCombatStateValue().creatures.length > 0 && 
    this.combatRoomService.getCombatStateValue().creatures.some(creature => {creature.initiative === 0})){
      return true;
    }
    return false;
  }
  openMenu(){
    document.getElementById("sidebar-master").style.width = "250px";
  }
  disable(){
    document.getElementById("sidebar-master").style.width = "0";
  }
  startCombat(){
    this.combatRoomService.startCombat();
  }
 
  openDiceMenu(){
    this.creatureMenu = false;
    this.diceMenu = true;
  }
  openCreatureMenu(){
    this.creatureMenu = true;
    this.diceMenu = false;
  }
  openConfirmDeleteModal(reference){
    this.modalReference = this.modalService.open(reference,{ centered: true });
  }
  rollInitiativeForLeftPlayersAndStart(){
    this.rollInitiativeOfLeftPlayers();
    this.modalReference.dismiss();
    this.combatRoomService.startCombat();
  }
  rollInitiativeOfLeftPlayers(){
    this.combatRoomService.updateCreatures(
      this.diceService.rollInitiativeOfCreatures(this.combatRoomService.getCombatStateValue().creatures)
    );
  }
}
