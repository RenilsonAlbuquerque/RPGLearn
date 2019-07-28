import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { PlaceMarker } from 'src/app/domain/models/comon/place-marker';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AttributeMarker } from '@angular/compiler/src/core';

@Component({
  selector: 'app-story-map',
  templateUrl: './story-map.component.html',
  styleUrls: ['./story-map.component.scss']
})
export class StoryMapComponent implements OnInit {

  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;

  private ctx: CanvasRenderingContext2D;
  
  private marker = new Image();
  private image = new Image();
  public markers : PlaceMarker[];
  
  closeResult: string;

  constructor(private modalService: NgbModal) { 
    this.marker.src = "http://www.clker.com/cliparts/w/O/e/P/x/i/map-marker-hi.png"
    this.image.src = "https://vignette.wikia.nocookie.net/travelogue/images/d/de/Barovia.png/revision/latest?cb=20170601222710"
    this.markers = [];
  }

  
  ngOnInit(): void {
  
    this.ctx = this.canvas.nativeElement.getContext('2d');
    this.ctx.drawImage(this.image,0,0,this.image.width,this.image.height,0,0,1200,800);
  }
  
  addMarkEvent(event: MouseEvent){
    this.markers.push({
      id:1,
      name: "Castelo Ravenloft",
      description: "O castelo do conde Strahd Von Zarovich",
      cordX: event.clientX,
      cordY: event.clientY
    } as PlaceMarker);
    this.ctx.drawImage(this.marker,event.clientX,event.clientY,15,20);
  }
  selectPlace(event: MouseEvent,content): PlaceMarker{
    var overMark = null;
    this.markers.forEach(function (marker: PlaceMarker){
      var distance = Math.sqrt( Math.pow((event.clientX - marker.cordX),2) + Math.pow((event.clientY - marker.cordY),2)   )
      if(distance < 100){
        overMark = marker;
      }
    });
    if(overMark){
      this.modalService.open(content, {size: 'xl'});
    } 
    return overMark; 
  }
}
