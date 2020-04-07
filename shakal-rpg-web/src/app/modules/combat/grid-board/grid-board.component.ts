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
    this.initializeSquares();
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.combatState = state
      });
  }
  initializeSquares(){
    let totalSize = this.dimensionX * this.dimensionY;
    for (let i = 0; i < this.dimensionY; i++) {
      this.squares[i] = [];
      for(let j = 0; j < this.dimensionX; j++){
        this.squares[i][j] = new GridBoardCardComponent();
      }  
    }
   
  }

  ngOnInit() {
    this.squares[5][5].setMonster(this.initializeMonster());
  }
  initializeMonster(): MonsterCard{
    return  {
      id: 3,
      name: "Monstro de Frankstein",
      level: {id: 12, value: 10, xp: 5900},
      lifePoints: 67,
      totalLifePoints: 67,
      imagePath: "https://upload.wikimedia.org/wikipedia/commons/a/a7/Frankenstein%27s_monster_%28Boris_Karloff%29.jpg",
      lifePercent: 0
    } as MonsterCard
  }
}
