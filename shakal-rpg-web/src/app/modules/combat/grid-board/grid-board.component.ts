import { Component, OnInit, ViewChild, ElementRef, AfterContentInit, AfterViewInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';
import { MatSliderChange } from '@angular/material/slider';
import { CardPosition } from 'src/app/domain/models/combat/card.position';

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


  private monsters: GridBoardCardComponent[];

  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService) { 
    this.monsters = [];
  }
  createsvr(squareDimension: number){
     // 横线与竖线的是距
     var dx = squareDimension;
     var dy = squareDimension;
     
     // 初始坐标原点
     var x = 0;
     var y = 0;
     var w = this.canvas.nativeElement.width;
     var h = this.canvas.nativeElement.height;
     
     // 单个步长所表示的长度
     
     var xy = 10;
     
     this.ctx.lineWidth = 1;
     
     // 画横线
     while (y < h) {
       y = y + dy;
       this.ctx.moveTo(x, y);
       this.ctx.lineTo(w, y);
       this.ctx.stroke();
       
       //横坐标的数字  
       this.ctx.font = "1px Calibri";  
       this.ctx.fillText("10", x, y);  
       xy += 10;  
     }
     
     // 画竖线
     y =0;  
     xy =10; 
     while (x < w) {
       x = x + dx;
       this.ctx.moveTo(x, y);  
       this.ctx.lineTo(x,h);  
       this.ctx.stroke();   
       //纵坐标的数字  
       this.ctx.font = "1px Calibri";  
       this.ctx.fillText("grey",x,10);    
       xy+=10;  
     }
  }
  drawImage(){
    this.image.src = "https://media-waterdeep.cursecdn.com/attachments/thumbnails/5/962/400/507/031.jpg";
    this.ctx = this.canvas.nativeElement.getContext('2d');
   
    this.image.onload = () => {
      this.canvas.nativeElement.height = this.image.height;
      this.canvas.nativeElement.width = this.image.width;
      this.ctx.drawImage(this.image,0,0);
      this.createsvr(28);
    }
  }
  applyZoom(value: number){
    this.svg.nativeElement.style.zoom = new Number(value).toString();
    this.zoomValue = value;
    console.log(value)
  }
  

  ngOnInit() {
    //this.drawImage();
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
      let numberZoom: number = (this.zoomValue > 0)?  this.zoomValue: 1;
      //monster.position = {x: ev.offsetX/ numberZoom , y: ev.offsetY /numberZoom}
      monster.position = this.calculatePositionDrop(ev.offsetX,ev.offsetY);
      this.monsters.push(squareMonster);
    }
  }
  private calculatePositionDrop(x: number, y: number): CardPosition{
    let numberZoom: number = (this.zoomValue > 0)?  this.zoomValue: 1;
    x = x/numberZoom;
    y = y/numberZoom;
    
    let jump:number = numberZoom * 30;
    let xResult:number = numberZoom * 30;
    let yResult:number = numberZoom * 30;
    for(var i = 0; i < x; i += jump){
        if(xResult >= x){
          if((xResult - x) >= jump/2.5){
            xResult -= jump; 
          }
          break;
        }else{
          xResult += jump;
        }
    }
    console.log("jump: " + jump)
    console.log("x:" +x + ", X: " + xResult);
    for(var j = 0; j < y; i += jump){
      if(yResult >= y){
        if((xResult - y) >= jump/2.5){
          yResult -= jump; 
        }
        break;
      }else{
        yResult += jump;
      }
    }
    console.log("y:" +y + ", Y: " + yResult);
    return {x:xResult, y:yResult};
    //return {x:x, y:y}
  }
  
}
