import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray } from '@angular/forms';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { StoryService } from '../story.module.service';
import { StoryCreateInput } from 'src/app/domain/models/story/story-create-input';
import { StoryCreate } from 'src/app/domain/models/story/story-create';
import {mapStoryFormToDTO} from 'src/app/domain/mappers/story.mapper';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';

@Component({
  selector: 'app-story-create',
  templateUrl: './story-create.component.html',
  styleUrls: ['./story-create.component.scss']
})
export class StoryCreateComponent implements OnInit {

  public detailFormGroup: FormGroup;
  public playersFormGroup: FormGroup;
  public placesFormGroup: FormGroup;
  public inputValues: StoryCreateInput;

  private modalReference;
  profilePicture: string;

  constructor(private _formBuilder: FormBuilder,private storyService: StoryService,
    private toastr: ToastrService,private router: Router,private modalService: NgbModal) { 
    this.detailFormGroup = this._formBuilder.group({
      profilePicture: [''],
      name: ['',Validators.required],
      description: ['',Validators.required]
    });
    this.playersFormGroup = this._formBuilder.group({
      players: [[],Validators.required]
    });
    this.placesFormGroup = this._formBuilder.group({
      places: this._formBuilder.array([  ])
    });
  }

  ngOnInit() {
    this.storyService.getStoryCreateInput().subscribe(
      response => (this.inputValues = response)  
    )
  }
  public onSubmit(){
    var storyDTO: StoryCreate = mapStoryFormToDTO(this.detailFormGroup,this.playersFormGroup,this.placesFormGroup)
    console.log(storyDTO)
    this.storyService.createStory(storyDTO).subscribe(
      response => (this.toastr.success("História cadastrada com sucesso"),
                  this.router.navigate(['home/story/list'])),
      error => (this.toastr.error(error)) 
    )
  }
  open(content) {
    this.modalReference = this.modalService.open(content, {size: 'xl'});
  }
  changePlayersFormValues(elements: KeyValue[]){
    this.playersFormGroup.controls['players'].setValue(elements);
  }
  addPlace(place: PlaceCreate){
    const control = <FormArray>this.placesFormGroup.get('places');
    control.push(this.createPlaceItem(place));
    this.modalReference.dismiss();
  }
  createPlaceItem(place: PlaceCreate): FormGroup {
    return this._formBuilder.group({
      name: [place.name,Validators.required],
      description: [place.background,Validators.required],
      map: [place.map,Validators.required],
    });
    
  }

}
