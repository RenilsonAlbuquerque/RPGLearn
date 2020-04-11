import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { CdkDragDrop } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  @ViewChild('self', { static: true })
  self: ElementRef<HTMLCanvasElement>;
  
  @Input() public monster: MonsterCard;
  constructor() { 
    
  }

  ngOnInit() {
    this.self.nativeElement.style.top = this.monster.position.y.toString() + "px";
    this.self.nativeElement.style.left = this.monster.position.x.toString() + "px";
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
