import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-story-map',
  templateUrl: './story-map.component.html',
  styleUrls: ['./story-map.component.scss']
})
export class StoryMapComponent implements OnInit {

  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  
  private image = new Image();

  constructor() { 
    this.image.src = "https://vignette.wikia.nocookie.net/travelogue/images/d/de/Barovia.png/revision/latest?cb=20170601222710"
  }

  
  ngOnInit(): void {
    this.ctx = this.canvas.nativeElement.getContext('2d');
    this.ctx.drawImage(this.image,0,0,this.image.width,this.image.height,0,0,1200,800);
  }
  
  addMarkEvent(){
    console.log("hello")
  }
}
