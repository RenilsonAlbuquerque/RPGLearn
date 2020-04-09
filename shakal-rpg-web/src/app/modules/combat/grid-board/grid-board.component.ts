import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit {

  private combatState: CombatState;
  private dimensionY: number = 11;
  private dimensionX: number = 11;
  private squareSize: number; 
  private squares: GridBoardCardComponent[][] = [];
  constructor(private combatRoomService: CombatRoomService) { 
    this.squareSize = 4;
    this.instantiateSquares();
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.combatState = state;
        this.initializeSquares();
      });
  }
  instantiateSquares(){
    let totalSize = this.dimensionX * this.dimensionY;
    for (let i = 0; i < this.dimensionY; i++) {
      this.squares[i] = [];
      for(let j = 0; j < this.dimensionX; j++){
        this.squares[i][j] = new GridBoardCardComponent();
      }  
    }
  }
  initializeSquares(){
   this.combatState.players.forEach(
     player => {
       console.log(player)
       if(player.position.x > 0 || player.position.y > 0){
         this.squares[player.position.x][player.position.y].monster = player
       }
     }
    );
    this.combatState.monsters.forEach(
      enemy => {
        if(enemy.position.x > 0 || enemy.position.y > 0){
          this.squares[enemy.position.x][enemy.position.y].monster = enemy
        }
      }
    )
  }

  ngOnInit() {
  }
  
}
