import { Component, OnInit, Output,EventEmitter, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { StoryCreate } from 'src/app/domain/models/story/story-create';
import { PlaceService } from '../place.module.service';
import { ToastrService } from 'ngx-toastr';
import { mapPlaceInFormToDto } from 'src/app/domain/mappers/place.mapper';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';


@Component({
  selector: 'app-place-create',
  templateUrl: './place-create.component.html',
  styleUrls: ['./place-create.component.scss']
})
export class PlaceCreateComponent implements OnInit {

  @Input()
  private storyId: number;
  @Output() adcionarLugar = new EventEmitter<PlaceOverview>();
  public placeForm: FormGroup;
  mapImagePath: string;

  constructor(private formBuilder: FormBuilder, private placeService: PlaceService,private toastr: ToastrService) { }

  ngOnInit() {
    this.placeForm = this.formBuilder.group({
      name: ['', Validators.required],
      background: ['', Validators.required],
      map: ['', Validators.required],
      xDimension: ['',Validators.required],
      yDimension: ['',Validators.required],
      squareDimension: [1.5,Validators.required]
    });
  }
  onSubmit(){
    var placeDTO: PlaceCreate = mapPlaceInFormToDto(this.placeForm);
    placeDTO.storyId = this.storyId;
    this.placeService.createPlace(placeDTO).subscribe(
      response => (this.toastr.success("História cadastrada com sucesso"),this.adcionarLugar.emit(response)),
      error => (this.toastr.error(error)) 
    )
    ;
  }

}
