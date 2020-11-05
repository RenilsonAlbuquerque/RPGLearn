import { Component, OnInit, ViewChild, ElementRef, Input, TemplateRef } from '@angular/core';
import { PlaceMarker } from 'src/app/domain/models/comon/place-marker';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AttributeMarker } from '@angular/compiler/src/core';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { ActivatedRoute } from '@angular/router';
import { PlaceService } from '../../place/place.module.service';
import { createSvgGridPlaceCreate } from 'src/app/infra/helpers/grid-board.helper';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { PlaceMarkOverview } from 'src/app/domain/models/place/place.mak.overview';

@Component({
  selector: 'app-story-map',
  templateUrl: './story-map.component.html',
  styleUrls: ['./story-map.component.scss']
})
export class StoryMapComponent implements OnInit {

  @ViewChild('mainContainerMapExhibition', { static: true })
  mainContainer: ElementRef<HTMLCanvasElement>;
  @ViewChild('imageContainerMapExhibition', { static: true })
  imageContainer: ElementRef<HTMLCanvasElement>;
  private svgBattleGrid: HTMLElement;
  private image = new Image();


  public place: PlaceDetail;



  @ViewChild('canvas', { static: true })
  canvas: ElementRef<HTMLCanvasElement>;


  private ctx: CanvasRenderingContext2D;
  
  private marker = new Image();
  //private image = new Image();
  public markers : PlaceMarkOverview[];
  
  //public currentMark: PlaceMarker;
  
  private placeId: number;

  private coordinateX: number;
  private coordinateY: number;

  constructor(private internModalService: InternModalService,private _activatedRoute: ActivatedRoute, private placeService:PlaceService) { 
    
  }

  
  ngOnInit(): void {
    this.marker.src = '../../../../assets/img/map-marker-hi.png';
    this.markers = [];
 
    this._activatedRoute.params.subscribe(params => {
      this.placeId = params['id'];
      this.placeService.getDetail(this.placeId).subscribe(
        result => {
          console.log(result);
          this.place = result;
          this.newDrawImage(result.map);
          this.placeService.getPlaceMarkOverviews(this.placeId).subscribe(
            result => {
              this.markers = result;
            });
        }, 
        (err) =>{
          console.log(err)
        }
      );
      
    });
   
    
  }
  
  addMarkEvent(event: MouseEvent,templatePlace: TemplateRef<any>){
   
    this.coordinateX = event.clientX,
    this.coordinateY = event.clientY
    this.internModalService.openLargeModal(templatePlace);
    //this.ctx.drawImage(this.marker,event.clientX,event.clientY,15,20);
  }
 
  pushMark(mark: PlaceMarkOverview){
    this.markers.push(mark);
  }


  ///-------------------------Canvas-------------------------------------------------------///
  newDrawImage(image: string){
    this.image.src = image;
    this.image.onload = () => {
      
      this.imageContainer.nativeElement.style.width = "fit-content";
      this.mainContainer.nativeElement.height = this.image.height;
      this.mainContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.height = this.image.height;
      this.imageContainer.nativeElement.width = this.image.width;
      
      this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGridPlaceCreate(0,this.image.naturalWidth,this.image.naturalHeight));
      this.imageContainer.nativeElement.style.backgroundImage = `url(${this.image.src})`;
      this.imageContainer.nativeElement.style.backgroundRepeat = `no-repeat`;
      this.mainContainer.nativeElement.style.height = '600px';
      this.mainContainer.nativeElement.style.overflow = 'auto';
      this.svgBattleGrid = document.getElementById("svggridCreate");
      if(this.imageContainer.nativeElement.children.length >1){
        this.imageContainer.nativeElement.removeChild(this.imageContainer.nativeElement.childNodes[1]);
      }
    }
  }
}
