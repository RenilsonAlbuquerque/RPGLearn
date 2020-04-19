import { Injectable } from '@angular/core';
import { CardPosition } from 'src/app/domain/models/combat/card.position';
import { ActionControl } from 'src/app/domain/models/combat/action.control';



@Injectable()
export class GridBoardService {
    
  private squareSize : number = 30;
  private boardZoom: number = 0;
  private playerMoving: string;
  private creatureAction:ActionControl;

  constructor(){
        
  }
  
  getSquareSize(): number{
    return this.squareSize;
  }
  setSquareSize(squareSize: number){
    this.squareSize = squareSize;
  }
  getBoardZoom(): number{
    return this.boardZoom;
  }
  setBoardZoom(boardZoom: number){
    this.boardZoom = boardZoom;
  }
  getCreatureAction():ActionControl{
    return this.creatureAction;
  }
  setCreatureAction(creature: ActionControl):void{
    this.creatureAction = creature;
  }
  moveCreature(target:CardPosition):CardPosition{
    let result = target;
    
    if(this.creatureAction != null){
       if(target.x > this.creatureAction.creature.position.x ){
         if(target.y > this.creatureAction.creature.position.y){
           for(let i = this.creatureAction.creature.speed; i > 0; i--){
              
           }
         }
       }
       this.creatureAction = null;
    } 
    return result;
  }
}