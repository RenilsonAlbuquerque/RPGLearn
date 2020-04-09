import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CombatRoomService } from '../services/combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-combat-screen',
  templateUrl: './combat-screen.component.html',
  styleUrls: ['./combat-screen.component.scss']
})
export class CombatScreenComponent implements OnInit {
  /*
  public monsters: MonsterCard[];
  public players: MonsterCard[];
  */
  private combatState: CombatState;
  private modalReference;
  

  messageHistory = [];
  storyid: number;

  constructor(private _activatedRoute: ActivatedRoute,private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
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
  openConfirmDeleteModal(reference){
    this.modalReference = this.modalService.open(reference,{ centered: true });
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
