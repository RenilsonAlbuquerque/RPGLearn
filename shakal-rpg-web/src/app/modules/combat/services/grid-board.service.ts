import { Injectable, ElementRef } from '@angular/core';
import { CardPosition } from 'src/app/domain/models/combat/card.position';
import { ActionControl } from 'src/app/domain/models/combat/action.control';
import { BoardConfig } from 'src/app/domain/models/combat/board.config';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';



@Injectable()
export class GridBoardService {
    
  private squareSize : number = 30;
  private boardZoom: number = 0;
  private playerMoving: string;
  private creatureAction:ActionControl;
  private gridBoardConfig: BoardConfig;


  constructor(){
    this.gridBoardConfig = {
      imagePath : 'https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/129763638/original/05c10920c7074e25558016afbdc34ad7784c4467/create-a-custom-tabletop-battle-map-for-your-campaign.jpg',
      xDimension: 12,
      yDimension: 12,
      squareDimension: 1.5
    }
        
  }
  getGridBoardConfig():BoardConfig{
    return this.gridBoardConfig;
  }
  setGridBoardConfig(config: BoardConfig){
    this.gridBoardConfig = config;
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