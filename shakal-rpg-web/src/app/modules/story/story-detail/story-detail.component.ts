import { Component, OnInit } from '@angular/core';
import { StoryDetail } from 'src/app/domain/models/story/story-detail';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryService } from '../story.module.service';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { UserManagement } from 'src/app/domain/models/user/user.management.input';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { UserService } from '../../user/user.module.service';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
  styleUrls: ['./story-detail.component.scss']
})
export class StoryDetailComponent implements OnInit {

  public story: StoryDetail;
  private storyid: number;
  public userManagement: UserManagement;

  public playersFormGroup: FormGroup;
  
  //opened: boolean;
  constructor(private _activatedRoute: ActivatedRoute, private storyService: StoryService,
    private router: Router, private modalService:InternModalService,private _formBuilder: FormBuilder,
    private userService: UserService) { 
      this.playersFormGroup = this._formBuilder.group({
        players: [[],Validators.required]
      });
      
      
    }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyid = params['id'];
      this.storyService.getStoryInfoById(this.storyid).subscribe(
        response => (this.story = response)  
      );
      this.userService.getUserManagementMetadata(this.storyid).subscribe(
        result =>{
          console.log(result)
          this.userManagement = result;
        },err =>{
          console.log(err)
        }
      );
    });
  }
  goView(place){
    console.log(place)
    this.router.navigate(['home/story/place', place.id])
  }
  goToCombat(){
    this.router.navigate(['home/combat/screen/', this.storyid])
  }
  openManagementModal(template){
    this.modalService.openLargeModal(template);
  }
  changePlayersFormValues(elements: KeyValue[]){
    this.playersFormGroup.controls['players'].setValue(elements);
  }
}
