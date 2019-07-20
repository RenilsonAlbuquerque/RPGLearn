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
  closeResult: string;
  constructor(private modalService: NgbModal) { 
    this.monsters = [];
    this.players = [];

    this.monsters.push({
      id: 1,
      name: "Dracolich",
      level: 18,
      lifePoints: 400
    } as MonsterCard);
    this.monsters.push({
      id: 2,
      name: "Planetário",
      level: 16,
      lifePoints: 350
    } as MonsterCard);

    this.players.push({
      id: 1,
      name: "Gnar D'Trath",
      level: 9,
      lifePoints: 81
    } as MonsterCard);
    this.players.push({
      id: 2,
      name: "Drago",
      level: 9,
      lifePoints: 91
    } as MonsterCard);
    this.players.push({
      id: 3,
      name: "Brakislavia",
      level: 9,
      lifePoints: 55
    } as MonsterCard);
  }

  ngOnInit() {
  }
  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Closed with: ${reason}`;
    });
  }

}
