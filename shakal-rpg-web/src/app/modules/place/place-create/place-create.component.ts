import { Component, OnInit, Output,EventEmitter, Input, ElementRef, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { StoryCreate } from 'src/app/domain/models/story/story-create';
import { PlaceService } from '../place.module.service';
import { ToastrService } from 'ngx-toastr';
import { mapPlaceInFormToDto } from 'src/app/domain/mappers/place.mapper';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';
import { convertFileToBase64 } from 'src/app/infra/helpers/file.helper';
import { createSvgGrid,createSvgGridPlaceCreate } from 'src/app/infra/helpers/grid-board.helper';


@Component({
  selector: 'app-place-create',
  templateUrl: './place-create.component.html',
  styleUrls: ['./place-create.component.scss']
})
export class PlaceCreateComponent implements OnInit {

  @ViewChild('mainContainerCreatePlace', { static: true })
  mainContainer: ElementRef<HTMLCanvasElement>;
  @ViewChild('imageContainerCreatePlace', { static: true })
  imageContainer: ElementRef<HTMLCanvasElement>;
  private svgBattleGrid: HTMLElement;
  private image = new Image();

  @Input()
  private storyId: number;
  @Output() adcionarLugar = new EventEmitter<PlaceOverview>();
  public placeForm: FormGroup;
  mapImagePath: string;


  //+++++++++++++++++Variables of map drag+++++++++++++++++++++//
  private isPressed: boolean;
  private startX: number;
  private startY: number;

  constructor(private formBuilder: FormBuilder, private placeService: PlaceService,private toastr: ToastrService) { }

  ngOnInit() {
    this.placeForm = this.formBuilder.group({
      name: ['', Validators.required],
      background: ['', Validators.required],
      map: ['', Validators.required],
      xDimension: ['',Validators.required],
      yDimension: ['',Validators.required],
      squareDimension: [1.5,Validators.required],
      squareDimensionCm:[30,Validators.required]
    });

    ///
    this.mainContainer.nativeElement.onmousemove = (ev) =>{
      if (this.isPressed === true) {
        this.mainContainer.nativeElement.style.cursor = "dragging";
        this.mainContainer.nativeElement.scrollLeft += (this.startX - (ev.clientX + this.mainContainer.nativeElement.scrollLeft));
        this.mainContainer.nativeElement.scrollTop += (this.startY - (ev.clientY + this.mainContainer.nativeElement.scrollTop));
      }
    }
    this.mainContainer.nativeElement.onmousedown = (ev) =>{
      //ev.preventDefault();
      if(ev.which == 1){
        
        this.isPressed = true;
        this.startX = ev.clientX + this.mainContainer.nativeElement.scrollLeft;
        this.startY = ev.clientY + this.mainContainer.nativeElement.scrollTop;
      }
      
    }
    this.mainContainer.nativeElement.onmouseup = (ev) =>{
      if(ev.which == 1){
        this.isPressed = false;
        this.mainContainer.nativeElement.style.cursor = "default";
      }
     
    }
  }
  onSubmit(){
    var placeDTO: PlaceCreate = mapPlaceInFormToDto(this.placeForm);
    console.log(placeDTO);
    placeDTO.storyId = this.storyId;
    this.placeService.createPlace(placeDTO).subscribe(
      response => (this.toastr.success("História cadastrada com sucesso"),this.adcionarLugar.emit(response)),
      error => (this.toastr.error(error)) 
    )
    ;
  }
  async changeCreatePlaceImage(event:any){
    let file = event.target.files[0];
    await convertFileToBase64(file).then(
      result => {
        this.mapImagePath = result as string,
        this.placeForm.controls['map'].setValue(result as string)
        this.newDrawImage(this.mapImagePath,this.placeForm.controls['squareDimensionCm'].value)
      }
    );
  }



  //--------------------------------------Método  de desenhar o mapa--------------------------------------//
  newDrawImage(image: string, squareDimensionInCm: number){
    this.image.src = image;
    this.image.onload = () => {
      
      this.imageContainer.nativeElement.style.width = "fit-content";
      this.mainContainer.nativeElement.height = this.image.height;
      this.mainContainer.nativeElement.width = this.image.width;
      this.imageContainer.nativeElement.height = this.image.height;
      this.imageContainer.nativeElement.width = this.image.width;
      
      this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',createSvgGridPlaceCreate(squareDimensionInCm,this.image.naturalWidth,this.image.naturalHeight));
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
  drawSvg(){
    let number = this.placeForm.controls['squareDimensionCm'].value;
    this.imageContainer.nativeElement.insertAdjacentHTML('afterbegin',
            createSvgGridPlaceCreate(number,this.image.naturalWidth,this.image.naturalHeight));
    
    // let svgElement = document.getElementById("svggridCreate");
    // let newElement = `<defs> 
    //       <pattern id="bigGridPattern" width="${number}" height="${number}" patternUnits="userSpaceOnUse">
    //         <rect width="80" height="80" fill="none"/>
    //           <path d="M ${number} 0 L 0 0 0 ${number}" fill="none" stroke="gray" stroke-width="1"/>
    //       </pattern>
    //       </defs>`;
    // console.log();      
    // svgElement.removeChild(svgElement.children[1]);
    // svgElement.nativeElement.insertAdjacentHTML(newElement);      
          
    

  }

}
