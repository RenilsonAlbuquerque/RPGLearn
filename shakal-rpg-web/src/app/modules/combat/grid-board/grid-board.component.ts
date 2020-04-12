import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';
import { calculatePositionDrop } from 'src/app/infra/helpers/grid-board.helper';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit{

  @ViewChild('combatCanvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;
  @ViewChild('containerCanvas', { static: true })
  svg: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;

  private image = new Image();
  zoomValue: number;

  private combatState: CombatState;
  private monsters: GridBoardCardComponent[];

  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService) { 
    this.monsters = [];
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.combatState = state,
        this.initializeBoardState()
      }
    );
  }
  ngOnInit() {
    //this.drawImage();
  }
  initializeBoardState(){
      this.combatState.monsters.forEach(monster => {
        let squareMonster: GridBoardCardComponent = new GridBoardCardComponent();
        squareMonster.setMonster(monster);
        squareMonster.setSquareSize(30);
        this.monsters.push(squareMonster);
      });
  }
  drawImage(){
    this.image.src = "https://media-waterdeep.cursecdn.com/attachments/thumbnails/5/962/400/507/031.jpg";
    this.ctx = this.canvas.nativeElement.getContext('2d');
   
    this.image.onload = () => {
      this.canvas.nativeElement.height = this.image.height;
      this.canvas.nativeElement.width = this.image.width;
      this.ctx.drawImage(this.image,0,0);
    }
  }
  applyZoom(value: number){
    this.svg.nativeElement.style.zoom = new Number(value).toString();
    this.zoomValue = value;
  }
  
  allowDrop(ev:DragEvent) {
    ev.preventDefault();
  }

  drop(ev: DragEvent) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("monster");
    let monster: MonsterCard = JSON.parse(data);

    if(monster){
      let squareMonster: GridBoardCardComponent = new GridBoardCardComponent();
      squareMonster.setMonster(monster);
      squareMonster.setSquareSize(30);
      monster.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,30);
      this.monsters.push(squareMonster);
    }
  }
}
