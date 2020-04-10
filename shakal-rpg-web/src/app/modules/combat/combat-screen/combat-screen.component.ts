import { Component, OnInit, ViewChild, TemplateRef, ContentChild, ElementRef, AfterViewInit, Inject, ViewContainerRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CombatRoomService } from '../services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';
import { DOCUMENT } from '@angular/common';
import { CdkDragDrop, moveItemInArray } from '@angular/cdk/drag-drop';



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

  

  // items = [
  //   'Item 0',
  //   'Item 1',
  //   'Item 2',
  //   'Item 3',
  //   'Item 4',
  //   'Item 5',
  //   'Item 6',
  //   'Item 7',
  // ]

  messageHistory = [];
  storyid: number;

  constructor( public element: ElementRef,private _activatedRoute: ActivatedRoute,private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
    this.combatRoomService.getCombatState().subscribe(
       state => this.combatState = state
    );

  }
  // drop(event: CdkDragDrop<string[]>) {
  //   console.log("Hereasdasdfsa")
  //   moveItemInArray(this.items, event.previousIndex, event.currentIndex);
  // }
  // drop2(event: CdkDragDrop<MonsterCard[]>) {
  //   console.log("Turn down fasdasd")
  //   ///moveItemInArray(this.items, event.previousIndex, event.currentIndex);
  // }

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
  addCreatureEnemy(monster: MonsterCard){
  
    this.combatRoomService.addMonsterEnemy(monster);
  }
  addCreatureAlly(monster: MonsterCard){
    this.combatRoomService.addMonsterAlly(monster);
  }

}
