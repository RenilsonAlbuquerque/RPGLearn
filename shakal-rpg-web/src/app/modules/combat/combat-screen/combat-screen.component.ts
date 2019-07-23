import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';


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
  

  constructor(private modalService: NgbModal) { 
    this.monsters = [];
    this.players = [];

   
    
  }

  ngOnInit() {
  }
  open(content) {
    this.modalReference = this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Closed with: ${reason}`;
    });
  }
  openSheet(content) {
    this.modalReference = this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Closed with: ${reason}`;
    });
  }

  addMonster(monster: MonsterCard){
    this.monsters.push(monster);
  }
  disposeModalAddMonster(result: boolean){
    this.modalReference.close();
  }

}
