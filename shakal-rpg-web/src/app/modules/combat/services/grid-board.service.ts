import { Injectable } from '@angular/core';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatRoomService } from './combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { BehaviorSubject, Observable } from 'rxjs';



@Injectable()
export class GridBoardService {
    
  private squareSize : number = 30;
  private boardZoom: number = 0;
   
  constructor(){
        
  }
  getSquareSize(): number{
    return this.squareSize;
  }
  setSquareSize(squareSize: number){
    this.squareSize = squareSize;
  }
  
}