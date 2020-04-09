import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit {

  private combatState: CombatState;
  private dimensionY: number = 9;
  private dimensionX: number = 22;
  private squareSize: number; 
  private squares: GridBoardCardComponent[][] = [];
  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService) { 

    // this.gridBoardService.instantiateSquares();
    // this.gridBoardService.getSquares().subscribe(
    //   data => {
    //     console.log("arrived thisssssssss waaaaayyyyy")
    //     this.squares = data
    //     this.squares.forEach(
    //           squarex => squarex.forEach(element => {
    //             if(element.getMonster()){
    //                 console.log(element)
    //             }  
    //           }));
    //   }
    // )
    
  }
  instantiateSquares(){
    for (let i = 0; i < this.dimensionY; i++) {
       this.squares[i] = [];
       for(let j = 0; j < this.dimensionX; j++){
         this.squares[i][j] = new GridBoardCardComponent();
       }  
     }
     
  }
  setCreaturesInSquares(combtState: CombatState){
    
    combtState.players.forEach(
     player => {
       if(player.position.x > 0 || player.position.y > 0){
         this.squares[player.position.x][player.position.y].setMonster(player);
       }
     }
    );
    combtState.monsters.forEach(
      enemy => {
        if(enemy.position.x > 0 || enemy.position.y > 0){
          this.squares[enemy.position.x][enemy.position.y].setMonster(enemy);
        }
      }
    )
  }

  ngOnInit() {
    this.instantiateSquares()
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.setCreaturesInSquares(state);
      });
  }
  
}
