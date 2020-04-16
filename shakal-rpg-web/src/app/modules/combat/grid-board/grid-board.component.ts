import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';
import { calculatePositionDrop, createSvgGrid, createSvgWalk, moveCreature } from 'src/app/infra/helpers/grid-board.helper';
import { ActionType } from 'src/app/domain/models/combat/action.type';

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
 
  private svgBattleGrid: HTMLElement;

  private ctx: CanvasRenderingContext2D;
  private image = new Image();
  
  private zoomValue: number;

  private combatState: CombatState;
  private monsters: GridBoardCardComponent[];

  
  private isPressed: boolean;
  private startX: number;
  private startY: number;

  private squareSize: number;
  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService) { 
    this.monsters = [];
    this.squareSize = 30;
    this.zoomValue = 1;
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.combatState = state,
        this.updateBoardState()
      }
    );
   
  }
  ngOnInit() {
    this.mainContainer.nativeElement.oncontextmenu = (ev) => {
      ev.preventDefault();
    }
    this.mainContainer.nativeElement.onmousedown = (ev) =>{
      //ev.preventDefault();
      if(ev.which == 3){
        
        this.isPressed = true;
        this.startX = ev.clientX + this.mainContainer.nativeElement.scrollLeft;
        this.startY = ev.clientY + this.mainContainer.nativeElement.scrollTop;
      }
      
    }
    this.mainContainer.nativeElement.onmouseup = (ev) =>{
      if(ev.which == 3){
        this.isPressed = false;
        this.mainContainer.nativeElement.style.cursor = "default";
      }
     
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
  updateBoardState(){
      let found = null;
      this.combatState.monsters.forEach(enemy => {
        if(enemy.position){
          let squareEnemy: GridBoardCardComponent = new GridBoardCardComponent(this.gridBoardService);
          squareEnemy.setMonster(enemy);
          squareEnemy.setSquareSize(this.squareSize);
          this.monsters.push(squareEnemy);
        }
      });
      this.combatState.players.forEach(ally =>{
        if(ally.position){
          let squareAlly: GridBoardCardComponent = new GridBoardCardComponent(this.gridBoardService);
          squareAlly.setMonster(ally);
          squareAlly.setSquareSize(this.squareSize);
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
      this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGrid(this.squareSize,this.image.naturalWidth,this.image.height));
      this.imageContainer.nativeElement.ondragover = (ev) => {this.allowDrop(ev)};
      this.imageContainer.nativeElement.ondrop = (ev) => {this.drop(ev)};
      this.imageContainer.nativeElement.style.backgroundImage = `url(${this.image.src})`;
      this.svgBattleGrid = document.getElementById("svggrid");
      //this.insertMovePreview();
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
      monster.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,this.squareSize);
      let squareMonster: GridBoardCardComponent = new GridBoardCardComponent(this.gridBoardService);
      squareMonster.setMonster(monster);
      squareMonster.setSquareSize(this.squareSize);
      this.monsters.push(squareMonster);
      this.combatRoomService.updateCreature(monster)
    }
  }
  handleDragToScroll(ev: DragEvent){
    ev.preventDefault();
  }
  handleClickBoard(event: MouseEvent){ 
    if(this.gridBoardService.getCreatureAction()){
      //can be null
      let action = this.gridBoardService.getCreatureAction();
      if(action.actionType == ActionType.move){
        let move = this.gridBoardService.moveCreature({x:event.offsetX, y: event.offsetY});
        if(move != null){
          this.svgBattleGrid.removeChild(document.getElementById("movePreview"));
          for(let i = 0; i < this.monsters.length;i ++){
            if(this.monsters[i].getMonster().combatId === action.creature.combatId){
              move = {
                x: move.x/this.zoomValue,
                y: move.y/this.zoomValue
              }
              let creature = this.monsters[i].getMonster();
              creature.position = move;
              this.combatRoomService.updateCreature(creature);
              let elementToBeMoved = document.getElementById(this.mainContainer.nativeElement.children[1].children[i].children[0].id);
              moveCreature(elementToBeMoved,move);
              
            }
          }
        }
      }
      if(action.actionType == ActionType.doubleMove){
        let move = this.gridBoardService.moveCreature({x:event.offsetX, y: event.offsetY});
        if(move != null){
          this.svgBattleGrid.removeChild(document.getElementById("doubleMovePreview"));
          for(let i = 0; i < this.monsters.length;i ++){
            if(this.monsters[i].getMonster().combatId === action.creature.combatId){
              move = {
                x: move.x/this.zoomValue,
                y: move.y/this.zoomValue
              }
              let creature = this.monsters[i].getMonster();
              creature.position = move;
              this.combatRoomService.updateCreature(creature);
              let elementToBeMoved = document.getElementById(this.mainContainer.nativeElement.children[1].children[i].children[0].id);
              moveCreature(elementToBeMoved,move);
            }
          }
        }
      }
    }
  }
}
