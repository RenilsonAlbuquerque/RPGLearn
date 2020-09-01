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
import { GridBoardConfig } from 'src/app/domain/models/combat/grid.board.config';

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

  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService,
    private monsterService: MonsterService,private placeService: PlaceService) { 

    
    

    this.zoomValue = 1;
    this.combatRoomService.getCombatState().subscribe(
      state => {
        this.combatState = state;
      }
    );
    this.gridBoardService.getGridBoardConfTest().subscribe(
      gridBoardState => {
        this.canvas = gridBoardState.canvas,
        this.mainContainer = gridBoardState.mainContainer,
        this.imageContainer = gridBoardState.imageContainer,
        this.svgBattleGrid = gridBoardState.svgBattleGrid,
        this.image = gridBoardState.image 
      }
    );
  }
  ngOnInit() {
    this.gridBoardService.setGridBoardConfTest({
      canvas: this.canvas,
      mainContainer: this.mainContainer,
      imageContainer: this.imageContainer,
      svgBattleGrid: this.svgBattleGrid,
      image:this.image
    }as GridBoardConfig);


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
    this.gridBoardService.newDrawImage(this.gridBoardService.getGridBoardConfig().imagePath);
    this.imageContainer.nativeElement.ondragover = (ev) => {this.allowDrop(ev)};
    this.imageContainer.nativeElement.ondrop = (ev) => {this.drop(ev)};
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

}
