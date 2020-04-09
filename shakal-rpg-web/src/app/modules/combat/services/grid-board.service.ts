import { Injectable } from '@angular/core';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatRoomService } from './combat-room.service';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { BehaviorSubject, Observable } from 'rxjs';



@Injectable()
export class GridBoardService {
    
    private squares: BehaviorSubject<GridBoardCardComponent[][]> ;
    private dimensionX = 20;
    private dimensionY = 10;

    constructor(private combatRoomService: CombatRoomService){
        this.instantiateSquares();
        this.combatRoomService.getCombatState().subscribe(
            data =>{
                this.setCreaturesInSquares(data);
            }
        )
        
    }
    public getSquares():Observable<GridBoardCardComponent[][]>{
        return this.squares.asObservable();
      }
    instantiateSquares(){
        
        let newSquares: GridBoardCardComponent[][] = [];
        for (let i = 0; i < this.dimensionY; i++) {
           newSquares[i] = [];
           for(let j = 0; j < this.dimensionX; j++){
             newSquares[i][j] = new GridBoardCardComponent();
           }  
         }
         this.squares = new BehaviorSubject<GridBoardCardComponent[][]>(newSquares);
    }
    
    // setSquares(squares: GridBoardCardComponent[][]){
    //     this.squares = squares;
    // }
    setCreaturesInSquares(combtState: CombatState){
        let newSquares: GridBoardCardComponent[][] = this.squares.getValue();
        combtState.players.forEach(
          player => {
            if(player.position.x > 0 && player.position.y > 0){
                newSquares[player.position.x][player.position.y].setMonster(player);
            }
          }
        );
        combtState.monsters.forEach(
           enemy => {
                if(enemy.position.x > 0 && enemy.position.y > 0){
                    newSquares[enemy.position.x][enemy.position.y].setMonster(enemy);
                }
            }
        )
        this.squares.next(newSquares);
        var squaresm : GridBoardCardComponent[][] = this.squares.getValue();
        // squaresm.forEach(
        //     squarex => squarex.forEach(element => {
        //       if(element.getMonster()){
        //           console.log(element)
        //       }  
        //     })
            
        //   );
          
    }
}