import { Component, OnInit, ViewChild, TemplateRef, ContentChild, ElementRef, AfterViewInit, Inject, ViewContainerRef } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CombatRoomService } from '../services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';
import { DOCUMENT } from '@angular/common';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';
import { generateRandomId } from 'src/app/infra/helpers/grid-board.helper';



@Component({
  selector: 'app-combat-screen',
  templateUrl: './combat-screen.component.html',
  styleUrls: ['./combat-screen.component.scss']
})
export class CombatScreenComponent implements OnInit  {
  
  /*
  public monsters: MonsterCard[];
  public players: MonsterCard[];
  */
  private combatState: CombatState;
  private modalReference;


  messageHistory = [];
  storyid: number;

  constructor(public element: ElementRef,private _activatedRoute: ActivatedRoute,private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
    this.combatRoomService.getCombatState().subscribe(
       state => this.combatState = state
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
  removeEnemy(index: number){
    this.combatRoomService.removeEnemy(index);
    this.modalReference.dismiss();
  }
  removeAlly(index: number){
    this.combatRoomService.removeAlly(index);
    this.modalReference.dismiss();
  }
  addCreatureEnemy(monster: CreatureCard){
    monster.combatId = generateRandomId();
    this.combatRoomService.addMonsterEnemy(monster);
  }
  addCreatureAlly(monster: CreatureCard){
    monster.combatId = generateRandomId();
    this.combatRoomService.addMonsterAlly(monster);
  }
}
