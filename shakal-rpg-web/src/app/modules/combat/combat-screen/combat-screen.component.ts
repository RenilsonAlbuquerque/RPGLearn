import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CombatRoomService } from '../services/combat-room.service';



@Component({
  selector: 'app-combat-screen',
  templateUrl: './combat-screen.component.html',
  styleUrls: ['./combat-screen.component.scss']
})
export class CombatScreenComponent implements OnInit {
  
  public monsters: MonsterCard[];
  public players: MonsterCard[];
  
  private modalReference;
  

  messageHistory = [];

  constructor(private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
    this.monsters = this.combatRoomService.getMonsters();
    this.players = this.combatRoomService.getPlayers();
    
  }
 
  ngOnInit() {
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
