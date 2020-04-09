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
  handleClickCard(){
    
  }

}
