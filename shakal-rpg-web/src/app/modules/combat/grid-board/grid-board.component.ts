import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';
import { calculatePositionDrop, createSvgGrid, createSvgWalk, moveCreature, adjustPosition, canMove, canDoubleMove, generateRandomId } from 'src/app/infra/helpers/grid-board.helper';
import { ActionType } from 'src/app/domain/models/combat/action.type';
import { MonsterService } from '../../monster/monster.module.service';
import { DragCreature } from 'src/app/domain/models/creature/drag.creature';
import { PlaceService } from '../../place/place.module.service';
import { BoardConfig } from 'src/app/domain/models/combat/board.config';

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

  
  private isPressed: boolean;
  private startX: number;
  private startY: number;

  //private squareSize: number;
  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService,
    private monsterService: MonsterService,private placeService: PlaceService) { 
    //this.monsters = [];
    //this.squareSize = 30;
    this.zoomValue = 1;
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.handleUpdateState(state);
        console.log(this.combatState)
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
    this.newDrawImage(this.gridBoardService.getGridBoardConfig().imagePath);
  }
 
  newDrawImage(image: string){
    this.image.src = image;
    this.image.onload = () => {
      
      this.imageContainer.nativeElement.style.width = "fit-content";
      this.mainContainer.nativeElement.height = this.image.height;
      this.mainContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.height = this.image.height;
      this.imageContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGrid(this.gridBoardService.getSquareSize(),this.image.naturalWidth,this.image.height));
      this.imageContainer.nativeElement.ondragover = (ev) => {this.allowDrop(ev)};
      this.imageContainer.nativeElement.ondrop = (ev) => {this.drop(ev)};
      this.imageContainer.nativeElement.style.backgroundImage = `url(${this.image.src})`;
      this.svgBattleGrid = document.getElementById("svggrid");
      console.log(image);
      //this.insertMovePreview();
    }
  }
  applyZoom(value: number){
    this.mainContainer.nativeElement.style.zoom = new Number(this.zoomValue += value).toString();
    this.zoomValue += value;
  }
  
  allowDrop(ev:DragEvent) {
    ev.preventDefault();
  }

  drop(ev: DragEvent) {
    ev.preventDefault();
    var data = ev.dataTransfer.getData("monster");
    if(data){
      let creature: DragCreature = JSON.parse(data);
      if(creature){
        this.monsterService.getMonsterCardById(creature.id).subscribe(
        response => {
          let newCreature = response
          newCreature.combatId = generateRandomId();
          newCreature.ally = creature.ally;
          newCreature.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,this.gridBoardService.getSquareSize());
          this.combatRoomService.addCreatureToCombat(newCreature)
        });
        return;
      }
    }
    let player = JSON.parse(ev.dataTransfer.getData("player"));
    if(player){
      player.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,this.gridBoardService.getSquareSize());
      this.combatRoomService.addCreatureToCombat(player)
    }
  }
  handleClickBoard(event: MouseEvent){ 
    if(this.gridBoardService.getCreatureAction()){
      //can be null
      let action = this.gridBoardService.getCreatureAction();
      if(action.actionType == ActionType.move && 
        canMove(this.gridBoardService.getCreatureAction().creature,{x:event.offsetX,y:event.offsetY},
        this.gridBoardService.getSquareSize(),this.zoomValue))
        {
        let move = this.gridBoardService.moveCreature({x:event.offsetX, y: event.offsetY});
        if(move != null){
          this.svgBattleGrid.removeChild(document.getElementById("movePreview"));
          for(let i = 0; i < this.combatState.creatures.length;i ++){
            if(this.combatState.creatures[i].combatId === action.creature.combatId){
              move = {
                x: move.x/this.zoomValue,
                y: move.y/this.zoomValue
              }
              let creature = this.combatState.creatures[i];
              creature.position = adjustPosition(move, this.gridBoardService.getSquareSize());
              this.combatRoomService.updateCreature(creature);
              // let elementToBeMoved = document.getElementById(this.mainContainer.nativeElement.children[1].children[i].children[0].id);
              //moveCreature(elementToBeMoved,move);
            }
          }
        }
      }
      if(action.actionType == ActionType.doubleMove && 
        canDoubleMove(this.gridBoardService.getCreatureAction().creature,{x:event.offsetX,y:event.offsetY},
        this.gridBoardService.getSquareSize(),this.zoomValue)){
        let move = this.gridBoardService.moveCreature({x:event.offsetX, y: event.offsetY});
        if(move != null){
          this.svgBattleGrid.removeChild(document.getElementById("doubleMovePreview"));
          for(let i = 0; i < this.combatState.creatures.length;i ++){
            if(this.combatState.creatures[i].combatId === action.creature.combatId){
              move = {
                x: move.x/this.zoomValue,
                y: move.y/this.zoomValue
              }
              let creature = this.combatState.creatures[i];
              creature.position = adjustPosition(move, this.gridBoardService.getSquareSize());
              this.combatRoomService.updateCreature(creature);
              // let elementToBeMoved = document.getElementById(this.mainContainer.nativeElement.children[1].children[i].children[0].id);
              //moveCreature(elementToBeMoved,move);
            }
          }
        }
      }
    }
  }
  handleUpdateState(state:CombatState){
    //console.log(this.combatState.placeId);
    //let oldState = {...this.combatState};
    this.combatState = state;
    // console.log(oldState.placeId);
    
    // if(oldState.placeId != this.combatState.placeId){
      
    //   this.placeService.getDetail(state.placeId).subscribe(
    //     result => {
    //       this.gridBoardService.setGridBoardConfig({
    //         imagePath: result.map,
    //         xDimension: result.xDimension,
    //         yDimension: result.yDimension,
    //         squareDimension: result.squareDimension
    //       } as BoardConfig);
    //       this.newDrawImage(result.map);
    //     },
    //     err =>{
    //       console.log(err)
    //     }
       
    //   )
    // }
    
  }
}
