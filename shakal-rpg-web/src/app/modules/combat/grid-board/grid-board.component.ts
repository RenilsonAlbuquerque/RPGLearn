import { Component, OnInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit {

  private dimensionY: number = 10;
  private dimensionX: number = 10;
  private squareSize: number; 
  private squares: GridBoardCardComponent[][] = [];
  constructor() { 
    this.squareSize = 4;
    this.initializeSquares();
  
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
  }

}
