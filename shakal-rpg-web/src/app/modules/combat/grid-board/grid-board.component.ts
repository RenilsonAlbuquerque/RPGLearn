import { Component, OnInit, ViewChild, ElementRef, AfterContentInit, AfterViewInit } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';
import { GridBoardCardComponent } from '../grid-board-card/grid-board-card.component';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { CombatRoomService } from '../services/combat-room.service';
import { GridBoardService } from '../services/grid-board.service';

@Component({
  selector: 'app-grid-board',
  templateUrl: './grid-board.component.html',
  styleUrls: ['./grid-board.component.scss']
})
export class GridBoardComponent implements OnInit{

  @ViewChild('combatCanvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;

  private image = new Image();
  private zoomValue: number;


  constructor(private combatRoomService: CombatRoomService,private gridBoardService: GridBoardService) { 
    
  }
 
  // createSvg(){
   

  //   this.ctx.canvas.width  = 1200;
  //   this.ctx.canvas.height = 800;
    
  //   var data = '<svg width="100%" height="100%" xmlns="http://www.w3.org/2000/svg"> \
  //       <defs> \
  //           <pattern id="smallGrid" width="8" height="8" patternUnits="userSpaceOnUse"> \
  //               <path d="M 8 0 L 0 0 0 8" fill="none" stroke="gray" stroke-width="0.5" /> \
  //           </pattern> \
  //           <pattern id="grid" width="80" height="80" patternUnits="userSpaceOnUse"> \
  //               <rect width="80" height="80" fill="url(#smallGrid)" /> \
  //               <path d="M 80 0 L 0 0 0 80" fill="none" stroke="gray" stroke-width="1" /> \
  //           </pattern> \
  //       </defs> \
  //       <rect width="100%" height="100%" fill="url(#smallGrid)" /> \
  //   </svg>';

  //   var DOMURL = window.URL || window.webkitURL || window;
    
  //   var img = new Image();
  //   var svg = new Blob([data], {type: 'image/svg+xml;charset=utf-8'});
  //   var url = URL.createObjectURL(svg);
  //   this.ctx.drawImage(img,0,0);
     

  // }
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
    this.image.src = "https://geekandsundry.com/wp-content/uploads/2016/06/mapfeaturedimage.jpg";
    this.ctx = this.canvas.nativeElement.getContext('2d');
   
    this.image.onload = () => {
      this.canvas.nativeElement.height = this.image.height;
      this.canvas.nativeElement.width = this.image.width;
      this.ctx.drawImage(this.image,0,0);
      this.createsvr(28);
    }

    
    
  }
  applyZoom(){
    this.canvas.nativeElement.style.zoom = "0.2"
  }
  

  ngOnInit() {
    this.drawImage();
    
  }
  
}
