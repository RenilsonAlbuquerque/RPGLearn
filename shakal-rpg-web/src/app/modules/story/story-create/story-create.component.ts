import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { StoryService } from '../story.module.service';
import { StoryCreateInput } from 'src/app/domain/models/story/story-create-input';
import { StoryCreate } from 'src/app/domain/models/story/story-create';
import mapStoryFormToDTO from 'src/app/domain/mappers/story.mapper';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-story-create',
  templateUrl: './story-create.component.html',
  styleUrls: ['./story-create.component.scss']
})
export class StoryCreateComponent implements OnInit {

  public detailFormGroup: FormGroup;
  public playersFormGroup: FormGroup;
  public inputValues: StoryCreateInput;
  profilePicture: string;

  constructor(private _formBuilder: FormBuilder,private storyService: StoryService,
    private toastr: ToastrService,private router: Router) { 
    this.detailFormGroup = this._formBuilder.group({
      profilePicture: [''],
      name: ['',Validators.required],
      description: ['',Validators.required]
    });
    this.playersFormGroup = this._formBuilder.group({
      players: [[],Validators.required]
    });
  }

  ngOnInit() {
    this.storyService.getStoryCreateInput().subscribe(
      response => (this.inputValues = response)  
    )
  }
  public onSubmit(){
    var storyDTO: StoryCreate = mapStoryFormToDTO(this.detailFormGroup,this.playersFormGroup)
    console.log(storyDTO)
    this.storyService.createStory(storyDTO).subscribe(
      response => (this.toastr.success("História cadastrada com sucesso"),
                  this.router.navigate(['home/story/list'])),
      error => (this.toastr.error(error)) 
    )
  }
  changePlayersFormValues(elements: KeyValue[]){
    this.playersFormGroup.controls['players'].setValue(elements);
  }

}
