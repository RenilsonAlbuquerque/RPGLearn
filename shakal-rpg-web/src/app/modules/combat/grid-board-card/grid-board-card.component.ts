import { Component, OnInit, Input } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { CdkDragDrop } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  
  @Input() public monster: MonsterCard;
  constructor() { 
    
  }

  ngOnInit() {
  
  }
  setMonster(monster: MonsterCard){
    
    if(this.monster == null){
      this.monster = monster;
    }
  }
  getMonster(): MonsterCard{
    return this.monster;
  }
  handleClickCard(){
    console.log(this.monster)
  }
  onDrop(event: CdkDragDrop<MonsterCard>) {
    console.log("here moithefucker")
    this.monster = event.item.data
  }
   allowDrop(ev) {
    ev.preventDefault();
  }
}
