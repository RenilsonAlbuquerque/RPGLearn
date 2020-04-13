import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';
import { calculatePositionDrop, createSvgGrid } from 'src/app/infra/helpers/grid-board.helper';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit{

  @ViewChild('combatCanvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;
  @ViewChild('mainContainer', { static: true })
  mainContainer: ElementRef<HTMLCanvasElement>;
  @ViewChild('imageContainer', { static: true })
  imageContainer: ElementRef<HTMLCanvasElement>;
  @ViewChild('svgGrid', { static: true })
  svgGrid: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  private image = new Image();
  
  zoomValue: number;

  private combatState: CombatState;
  private monsters: GridBoardCardComponent[];

  
  private isPressed: boolean;
  private startX: number;
  private startY: number;


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
    this.mainContainer.nativeElement.onmousedown = (ev) =>{
      this.isPressed = true;
      this.startX = ev.clientX + this.mainContainer.nativeElement.scrollLeft;
      this.startY = ev.clientY + this.mainContainer.nativeElement.scrollTop;
    }
    this.mainContainer.nativeElement.onmouseup = () =>{
      this.isPressed = false;
      this.mainContainer.nativeElement.style.cursor = "default";
    }
    this.mainContainer.nativeElement.onmousemove = (ev) =>{
      if (this.isPressed === true) {
        this.mainContainer.nativeElement.style.cursor = "dragging";
        this.mainContainer.nativeElement.scrollLeft += (this.startX - (ev.clientX + this.mainContainer.nativeElement.scrollLeft));
        this.mainContainer.nativeElement.scrollTop += (this.startY - (ev.clientY + this.mainContainer.nativeElement.scrollTop));
      }
    }
    this.newDrawImage();
  }
  initializeBoardState(){
      this.combatState.monsters.forEach(enemy => {
        if(enemy.position){
          let squareEnemy: GridBoardCardComponent = new GridBoardCardComponent();
          squareEnemy.setMonster(enemy);
          squareEnemy.setSquareSize(30);
          this.monsters.push(squareEnemy);
        }
      });
      this.combatState.players.forEach(ally =>{
        if(ally.position){
          let squareAlly: GridBoardCardComponent = new GridBoardCardComponent();
          squareAlly.setMonster(ally);
          squareAlly.setSquareSize(30);
          this.monsters.push(squareAlly);
        }
      });
  }
  drawImage(){
    this.image.src = "https://1.bp.blogspot.com/-skjFbWikSuU/VvUUhJu7ImI/AAAAAAAAGXw/7EtMwcNzPfw30x3CKdyo3wAYCxU7Qhr1g/s1600/dp6links.jpg";
    this.ctx = this.canvas.nativeElement.getContext('2d');
   
    this.image.onload = () => {
      this.canvas.nativeElement.height = this.image.height;
      this.canvas.nativeElement.width = this.image.width;
      this.ctx.drawImage(this.image,0,0);
    }
  }
  newDrawImage(){
    this.image.src = "https://i.redd.it/7igkmw001p121.jpg";
    this.image.onload = () => {
      
      this.imageContainer.nativeElement.style.width = "fit-content";
      this.mainContainer.nativeElement.height = this.image.height;
      this.mainContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.height = this.image.height;
      this.imageContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGrid(30,this.image.naturalWidth,this.image.height));
      this.imageContainer.nativeElement.ondragover = (ev) => {this.allowDrop(ev)};
      this.imageContainer.nativeElement.ondrop = (ev) => {this.drop(ev)};
      this.imageContainer.nativeElement.style.backgroundImage = `url(${this.image.src})`;
    }
  }
  applyZoom(value: number){
    this.mainContainer.nativeElement.style.zoom = new Number(value).toString();
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
  handleDragToScroll(ev: DragEvent){
    ev.preventDefault();
  }
}
