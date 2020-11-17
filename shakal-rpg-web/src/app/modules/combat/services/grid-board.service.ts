import { Injectable, ElementRef } from '@angular/core';
import { CardPosition } from 'src/app/domain/models/combat/card.position';
import { ActionControl } from 'src/app/domain/models/combat/action.control';
import { BoardConfig } from 'src/app/domain/models/combat/board.config';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { GridBoardConfig } from 'src/app/domain/models/combat/grid.board.config';
import { createSvgGrid } from 'src/app/infra/helpers/grid-board.helper';
import { BehaviorSubject, Observable } from 'rxjs';
import { DragCreature } from 'src/app/domain/models/creature/drag.creature';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import  {BASE_URL} from '../../../infra/config/constants';
import { MapAreaState } from 'src/app/domain/models/combat/map.area.state';
import { RxStompService } from '@stomp/ng2-stompjs';
import { IMessage } from '@stomp/stompjs';



@Injectable()
export class GridBoardService {
    
  private squareSize : number = 30;
  private boardZoom: number = 0;
  private playerMoving: string;
  private creatureAction:ActionControl;
  //private gridBoardConfig: BoardConfig;


  private gridBoardPlace:BehaviorSubject<PlaceDetail>;
  private gridBoardConfTest: BehaviorSubject<GridBoardConfig>;
  private gridBoardStatus : BehaviorSubject<MapAreaState>; 
  private storyId: number;


  private movimentLeft: number;
  private doubleMovimentLeft: number;
  
  constructor(private httpClient: HttpClient,protected rxStompService: RxStompService){
    this.gridBoardPlace = new BehaviorSubject<PlaceDetail>({
      id: 0,
      name: "O lugar misterioso",
      background: "O vazio sem existência",
      map: "https://s3.amazonaws.com/nerit-cms/neritpolitica/block/block_0960-black-friday1.png",
      xDimension: 120,
      yDimension: 120,
      squareDimension: 1.5,
      squareSizeCm: 30
    });
    this.gridBoardConfTest =  new BehaviorSubject<GridBoardConfig>({
      canvas: null,
      mainContainer: null,
      imageContainer: null,
      svgBattleGrid: null,
      image: new Image()
    });
        
  }
  public initializeGridBoard(storyId: number){
    this.storyId = storyId;
    this.rxStompService.watch('/topic/combat-area/'+ storyId).subscribe((message: IMessage) => {
      this.gridBoardStatus.next(JSON.parse(message.body) as MapAreaState);
      console.log(JSON.parse(message.body))
    })
    
  }
  protected onSendMessage(combatState: MapAreaState) {
    this.rxStompService.publish({destination: '/app/combat/' + this.storyId, body: JSON.stringify(combatState)});
  }
  setGridBoardConfTest(test:GridBoardConfig){
    this.gridBoardConfTest.next(test);
  }
  public getGridBoardConfTest():Observable<GridBoardConfig>{
    return this.gridBoardConfTest.asObservable();
  }
  public getPlaceStatus():Observable<PlaceDetail>{
    return this.gridBoardPlace.asObservable();
  }
  getGridBoardConfig():PlaceDetail{
    return this.gridBoardPlace.value;
  }
  setGridBoardConfig(config: PlaceDetail){
    this.gridBoardPlace.next( config);
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
  public updateMapById(placeId:number){
    this.httpClient.get<PlaceDetail>(`${BASE_URL}place/info/${placeId}`).subscribe(
      place => {
        this.updateMap(place);
      }
    )
  }
  public updateMap(place: PlaceDetail){
    this.gridBoardPlace.next(place);
    this.squareSize = place.squareSizeCm;
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
      newObject.imageContainer.nativeElement.style.backgroundImage = `url(${newObject.image.src})`;
      newObject.imageContainer.nativeElement.style.backgroundRepeat = `no-repeat`;
      newObject.svgBattleGrid = document.getElementById("svggrid");
      if(newObject.imageContainer.nativeElement.children.length >1){
        newObject.imageContainer.nativeElement.removeChild(newObject.imageContainer.nativeElement.childNodes[1]);
      }

      this.gridBoardConfTest.next(newObject);
      //this.insertMovePreview();
    }
  }
  
}