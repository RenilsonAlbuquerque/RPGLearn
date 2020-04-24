import { Component, OnInit, Input, ViewChild, ElementRef } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { GridBoardService } from '../services/grid-board.service';
import { createSvgWalk, generateRandomId, createSvgDoubleMove } from 'src/app/infra/helpers/grid-board.helper';
import { ActionType } from 'src/app/domain/models/combat/action.type';


@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  @ViewChild('self', { static: true })
  self: ElementRef<HTMLCanvasElement>;
  
  @Input() public monster: CreatureCard;

  public menuOpen: boolean;
  private selfId: string;
  
  constructor(private gridBoardService: GridBoardService) { 
    this.menuOpen = false;
  }

  ngOnInit() {
    this.self.nativeElement.style.top = this.monster.position.y.toString() + "px";
    this.self.nativeElement.style.left = this.monster.position.x.toString() + "px";
    this.self.nativeElement.style.height = (this.gridBoardService.getSquareSize() * this.monster.size).toString() + "px";
    this.self.nativeElement.style.width = (this.gridBoardService.getSquareSize() * this.monster.size).toString() + "px";
    this.selfId = this.monster.combatId;
    
  }
  setMonster(monster: CreatureCard){
    if(this.monster == null){
      this.monster = monster;
    }
  }
  getMonster(): CreatureCard{
    return this.monster;
  }
  handleClickCard(){
    this.menuOpen = !this.menuOpen;
    
  }
  handleMove(){
    this.resetMoves();
    this.gridBoardService.setCreatureAction({creature:this.monster,actionType: ActionType.move});
    document.getElementById("svggrid").innerHTML += createSvgWalk(30,this.monster.speed,this.monster.position, this.monster.size);
  }
  handleDoubleMove(){
    this.resetMoves();
    this.gridBoardService.setCreatureAction({creature:this.monster,actionType: ActionType.doubleMove});
    document.getElementById("svggrid").innerHTML += createSvgDoubleMove(30,this.monster.speed,this.monster.position, this.monster.size);
  }
  resetMoves(){
    if(document.getElementById("doubleMovePreview") != null){
      let element = document.getElementById("doubleMovePreview");
      element.parentNode.removeChild(element);
    }
    if(document.getElementById("movePreview") != null){
      let element = document.getElementById("movePreview");
      element.parentNode.removeChild(element);
    }
  }
 
}
