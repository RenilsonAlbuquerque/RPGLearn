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
  closeResult: string;
  

  constructor(private modalService: NgbModal, private combatRoomService: CombatRoomService) { 
    this.monsters = this.combatRoomService.getMonsters();
  }

  ngOnInit() {
  }
  open(content) {
    this.modalReference = this.modalService.open(content, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Closed with: ${reason}`;
    });
  }
  openSheet(content) {
    this.modalReference = this.modalService.open(content, {size: 'xl'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Closed with: ${reason}`;
    });
  }
  disposeModalAddMonster(result: boolean){
    this.modalReference.close();
  }
  removeMonster(index: number){
    this.combatRoomService.removeMonster(index);
  }
  

}
