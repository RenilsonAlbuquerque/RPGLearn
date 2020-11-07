import { Component, OnInit, Input, ViewChild, ElementRef, TemplateRef } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { GridBoardService } from '../services/grid-board.service';
import { createSvgWalk, generateRandomId, createSvgDoubleMove } from 'src/app/infra/helpers/grid-board.helper';
import { ActionType } from 'src/app/domain/models/combat/action.type';
import { CombatRoomService } from '../services/combat-room.service';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { CreatureService } from 'src/app/infra/services/creature.service';


@Component({
  selector: 'app-grid-board-card',
  templateUrl: './grid-board-card.component.html',
  styleUrls: ['./grid-board-card.component.scss']
})
export class GridBoardCardComponent implements OnInit {

  @ViewChild('self', { static: true })
  self: ElementRef<HTMLCanvasElement>;
  
  @Input() public monster: CreatureCard;

  public mobile: boolean;
  public menuOpen: boolean;
  public selfId: string;
  public imageToken: String;

  private squareSizeInCm: number;
  
  constructor(private gridBoardService: GridBoardService,
    private combatRoomService: CombatRoomService, private internModalService: InternModalService,
    private creatureService: CreatureService) { 
    // if(/Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini|Mobile|mobile|CriOS/i.test(navigator.userAgent)){
    //     this.mobile = true;
    // }else{
    //     this.mobile = false;
    // }
    this.menuOpen = false;
    this.gridBoardService.getPlaceStatus().subscribe(
      state => {
        this.squareSizeInCm = state.squareSizeCm;
        //this.handleReloadCard(this.squareSizeInCm)
      }
    );
     if(window.innerWidth < 1000){
       console.log(window.innerWidth)
        this.mobile = true;
    }else{
        this.mobile = false;
    }
  }

  ngOnInit() {
    this.handleReloadCard(this.squareSizeInCm);    
  }
  setMonster(monster: CreatureCard){
    if(this.monster == null){
      this.monster = monster;
      console.log(this.monster)
    }
  }
  getMonster(): CreatureCard{
    return this.monster;
  }
  get isMyTurn():boolean{
    if(this.monster.playerId && this.monster.playerId > 0){
      return this.monster.combatId === this.combatRoomService.getCombatStateValue().currentCreatureTurn;
    }else{
      return this.monster.combatId === this.combatRoomService.getCombatStateValue().currentCreatureTurn && this.monster.playerId <= 0;
    }
    
  }
  handleClickCard(){
    if(!this.mobile){
      this.menuOpen = !this.menuOpen;
    }
    
  }
  handleMove(){
    this.resetMoves();
    this.gridBoardService.setCreatureAction({creature:this.monster,actionType: ActionType.move});
    document.getElementById("svggrid").innerHTML += createSvgWalk(this.gridBoardService.getSquareSize(),this.monster.speed,this.monster.position, this.monster.size);
  }
  handleDoubleMove(){
    this.resetMoves();
    this.gridBoardService.setCreatureAction({creature:this.monster,actionType: ActionType.doubleMove});
    document.getElementById("svggrid").innerHTML += createSvgDoubleMove(this.gridBoardService.getSquareSize(),this.monster.speed,this.monster.position, this.monster.size);
  }
  handleOpenSheet(templatePlayer: TemplateRef<any>,templateNPC:TemplateRef<any>){
    if(this.monster.playerId > 0){
      this.internModalService.openExtraLargeModal(templatePlayer);
    }else{
      this.internModalService.openExtraLargeModal(templateNPC);
    }
    
  }
  handleEndTurn(){
    this.resetMoves();
    this.combatRoomService.passTurn(this.monster.combatId).subscribe(
      result =>{},err =>{console.log(err)}
    );
  }
  resetMoves(){
    if(document.getElementById("doubleMovePreview") != null){
      let element = document.getElementById("doubleMovePreview");
      element.parentNode.removeChild(element);
    }
    if(document.getElementById("movePreview") != null){
      let element = document.getElementById("movePreview");
      element.parentNode.removeChild(element);
    }
  }
  handleReloadCard(squareSizeInCm: number){
    console.log(squareSizeInCm)
    this.self.nativeElement.style.top = this.monster.position.y.toString() + "px";
    this.self.nativeElement.style.left = this.monster.position.x.toString() + "px";
    this.self.nativeElement.style.height = (squareSizeInCm * this.monster.size).toString() + "px";
    this.self.nativeElement.style.width = (squareSizeInCm * this.monster.size).toString() + "px";
    this.selfId = this.monster.combatId;
    console.log(this.selfId)
    this.creatureService.getCreatureTokenById(this.monster.id).subscribe(
      response =>{
        this.imageToken = response.picture;
      }
    );
  }
  
 
}
