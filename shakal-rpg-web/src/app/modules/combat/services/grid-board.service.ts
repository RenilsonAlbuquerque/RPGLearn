import { Injectable, ElementRef } from '@angular/core';
import { CardPosition } from 'src/app/domain/models/combat/card.position';
import { ActionControl } from 'src/app/domain/models/combat/action.control';
import { BoardConfig } from 'src/app/domain/models/combat/board.config';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { GridBoardConfig } from 'src/app/domain/models/combat/grid.board.config';
import { createSvgGrid } from 'src/app/infra/helpers/grid-board.helper';
import { BehaviorSubject, Observable } from 'rxjs';
import { DragCreature } from 'src/app/domain/models/creature/drag.creature';



@Injectable()
export class GridBoardService {
    
  private squareSize : number = 30;
  private boardZoom: number = 0;
  private playerMoving: string;
  private creatureAction:ActionControl;
  private gridBoardConfig: BoardConfig;


  private gridBoardConfTest: BehaviorSubject<GridBoardConfig>;

  constructor(){
    this.gridBoardConfig = {
      imagePath : 'https://fiverr-res.cloudinary.com/images/t_main1,q_auto,f_auto,q_auto,f_auto/gigs/129763638/original/05c10920c7074e25558016afbdc34ad7784c4467/create-a-custom-tabletop-battle-map-for-your-campaign.jpg',
      xDimension: 12,
      yDimension: 12,
      squareDimension: 1.5
    }
    this.gridBoardConfTest =  new BehaviorSubject<GridBoardConfig>({
      canvas: null,
      mainContainer: null,
      imageContainer: null,
      svgBattleGrid: null,
      image: new Image()
    });
        
  }
  setGridBoardConfTest(test:GridBoardConfig){
    this.gridBoardConfTest.next(test);
  }
  public getGridBoardConfTest():Observable<GridBoardConfig>{
    return this.gridBoardConfTest.asObservable();
  }
  getGridBoardConfig():BoardConfig{
    return this.gridBoardConfig;
  }
  setGridBoardConfig(config: BoardConfig){
    this.gridBoardConfig = config;
  }
  getSquareSize(): number{
    return this.squareSize;
  }
  setSquareSize(squareSize: number){
    this.squareSize = squareSize;
  }
  getBoardZoom(): number{
    return this.boardZoom;
  }
  setBoardZoom(boardZoom: number){
    this.boardZoom = boardZoom;
  }
  getCreatureAction():ActionControl{
    return this.creatureAction;
  }
  setCreatureAction(creature: ActionControl):void{
    this.creatureAction = creature;
  }
  moveCreature(target:CardPosition):CardPosition{
    let result = target;
    
    if(this.creatureAction != null){
       if(target.x > this.creatureAction.creature.position.x ){
         if(target.y > this.creatureAction.creature.position.y){
           for(let i = this.creatureAction.creature.speed; i > 0; i--){
              
           }
         }
       }
       this.creatureAction = null;
    } 
    return result;
  }

  public updateMap(place: PlaceDetail){
    this.newDrawImage(place.map);
  }

  newDrawImage(image: string){
    let newObject = this.gridBoardConfTest.value;
    newObject.image.src = image;
    newObject.image.onload = () => {
      
      
      newObject.imageContainer.nativeElement.style.width = "fit-content";
      newObject.mainContainer.nativeElement.height = newObject.image.height;
      newObject.mainContainer.nativeElement.width = newObject.image.width;
      newObject.imageContainer.nativeElement.height = newObject.image.height;
      newObject.imageContainer.nativeElement.width = newObject.image.width;

      
      newObject.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGrid(this.getSquareSize(),newObject.image.naturalWidth,newObject.image.naturalHeight));
      //this.gridBoardConfTest.imageContainer.nativeElement.ondragover = (ev) => {this.allowDrop(ev)};
      //this.gridBoardConfTest.imageContainer.nativeElement.ondrop = (ev) => {this.drop(ev)};
      newObject.imageContainer.nativeElement.style.backgroundImage = `url(${newObject.image.src})`;
      newObject.imageContainer.nativeElement.style.backgroundRepeat = `no-repeat`;
      newObject.svgBattleGrid = document.getElementById("svggrid");
      newObject.imageContainer.nativeElement.removeChild(newObject.imageContainer.nativeElement.childNodes[1]);

      this.gridBoardConfTest.next(newObject);
      //this.insertMovePreview();
    }
  }


  // allowDrop(ev:DragEvent) {
  //   ev.preventDefault();
  // }

  // drop(ev: DragEvent) {
  //   ev.preventDefault();
  //   var data = ev.dataTransfer.getData("monster");
  //   if(data){
  //     let creature: DragCreature = JSON.parse(data);
  //     if(creature){
  //       this.monsterService.getMonsterCardById(creature.id).subscribe(
  //       response => {
  //         let newCreature = response
  //         newCreature.combatId = generateRandomId();
  //         newCreature.ally = creature.ally;
  //         newCreature.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,this.gridBoardService.getSquareSize());
  //         this.combatRoomService.addCreatureToCombat(newCreature)
  //       });
  //       return;
  //     }
  //   }
  //   let player = JSON.parse(ev.dataTransfer.getData("player"));
  //   if(player){
  //     player.position = calculatePositionDrop(ev.offsetX,ev.offsetY,this.zoomValue,this.gridBoardService.getSquareSize());
  //     this.combatRoomService.addCreatureToCombat(player)
  //   }
  // }
  
}