import { Component, OnInit, ViewChild, TemplateRef, ContentChild, ElementRef, AfterViewInit, Inject, ViewContainerRef } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CombatRoomService } from '../services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';
import { generateRandomId } from 'src/app/infra/helpers/grid-board.helper';



@Component({
  selector: 'app-combat-screen',
  templateUrl: './combat-screen.component.html',
  styleUrls: ['./combat-screen.component.scss']
})
export class CombatScreenComponent implements OnInit  {
  
  private combatState: CombatState;
  private modalReference;
  private combatLevel: string;
  storyid: number;

  constructor(public element: ElementRef,private _activatedRoute: ActivatedRoute,private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
    this.combatRoomService.getCombatState().subscribe(
       state => {this.combatState = state,
        this.updateCombatDifficult()}
    );

  }
  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyid = params['id'];
      this.combatRoomService.initializeCombat(this.storyid);
    });
  }
  open(content) {
    this.modalReference = this.modalService.open(content, {size: 'xl'});
  }
  openConfirmDeleteModal(){
    let element = document.getElementById("confirmDeleteDialog");
    this.modalReference = this.modalService.open(element,{ centered: true });
  }
  openSheet(content) {
    this.modalReference = this.modalService.open(content, {size: 'xl'});
  }
  disposeModalAddMonster(result: boolean){
    this.modalReference.dismiss();
  }
  removeEnemy(enemyCombatId: string){
    this.combatRoomService.removeEnemy(enemyCombatId);
    this.modalReference.dismiss();
  }
  removeAlly(index: number){
    this.combatRoomService.removeAlly(index);
    this.modalReference.dismiss();
  }
  addCreatureEnemy(enemy: CreatureCard){
    enemy.combatId = generateRandomId();
    enemy.ally = false;
    this.combatRoomService.addMonsterEnemy(enemy);
  }
  addCreatureAlly(ally: CreatureCard){
    ally.combatId = generateRandomId();
    ally.ally = true;
    this.combatRoomService.addMonsterAlly(ally);
  }
  updateCombatDifficult(): void{
    if(this.combatState.dificult == 1){
      this.combatLevel = "Fácil";
    }
    if(this.combatState.dificult == 2){
      this.combatLevel = "Médio";
    }
    if(this.combatState.dificult == 3){
      this.combatLevel = "Difícil";
    }
    if(this.combatState.dificult == 4){
      this.combatLevel = "Mortal";
    }
  }
}
