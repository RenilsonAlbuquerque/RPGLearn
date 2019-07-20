import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';


@Component({
  selector: 'app-combat-screen',
  templateUrl: './combat-screen.component.html',
  styleUrls: ['./combat-screen.component.scss']
})
export class CombatScreenComponent implements OnInit {

  public monsters: MonsterCard[];
  public players: MonsterCard[];

  constructor() { 
    this.monsters = [];
    this.players = [];

    this.monsters.push({
      id: 1,
      name: "Strahd",
      level: 18,
      lifePoints: 400
    } as MonsterCard);
    this.monsters.push({
      id: 2,
      name: "Abade",
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

}
