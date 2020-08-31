import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { mapPlaceInFormToDto } from 'src/app/domain/mappers/place.mapper';

@Component({
  selector: 'app-place-create',
  templateUrl: './place-create.component.html',
  styleUrls: ['./place-create.component.scss']
})
export class PlaceCreateComponent implements OnInit {

  @Output() adcionarLugar = new EventEmitter<PlaceCreate>();
  public placeForm: FormGroup;
  mapImagePath: string;

  constructor(private formBuilder: FormBuilder) { }

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
    var place: PlaceCreate = mapPlaceInFormToDto(this.placeForm);
    this.adcionarLugar.emit(place)
  }

}
