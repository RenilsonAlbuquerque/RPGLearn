import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { CdkDragDrop } from '@angular/cdk/drag-drop';
import { GridBoardService } from '../services/grid-board.service';

@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  @ViewChild('self', { static: true })
  self: ElementRef<HTMLCanvasElement>;
  
  @Input() public monster: MonsterCard;
  private squareSize: number;
  constructor() { 
    
  }

  ngOnInit() {
    this.self.nativeElement.style.top = this.monster.position.y.toString() + "px";
    this.self.nativeElement.style.left = this.monster.position.x.toString() + "px";
    this.self.nativeElement.style.height = (30 * this.monster.size).toString() + "px";
    this.self.nativeElement.style.width = (30 * this.monster.size).toString() + "px";
  }
  getSquareSize(): number{
    return this.squareSize;
  }
  setSquareSize(squareSize: number){
    this.squareSize = squareSize;
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
}
