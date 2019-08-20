import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

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
      map: ['', Validators.required]
    });

  }

  onSubmit(){
    var place = {
      name: this.placeForm.controls['name'].value,
      background: this.placeForm.controls['background'].value,
      map: this.placeForm.controls['map'].value,
      
    }as PlaceCreate;

    this.adcionarLugar.emit(place)
  }

}
