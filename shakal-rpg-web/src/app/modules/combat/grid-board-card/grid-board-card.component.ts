import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  
  public monster: MonsterCard;
  constructor() { 
    
  }

  ngOnInit() {
  
  }
  setMonster(monster: MonsterCard){
    if(this.monster != null){
      this.monster = monster;
    }
  }
  initializeMonster(){
    this.monster = {
      id: 3,
      name: "Monstro de Frankstein",
      level: {id: 12, value: 10, xp: 5900},
      lifePoints: 67,
      totalLifePoints: 67,
      imagePath: "https://upload.wikimedia.org/wikipedia/commons/a/a7/Frankenstein%27s_monster_%28Boris_Karloff%29.jpg",
      lifePercent: 0
    } as MonsterCard
  }

}
