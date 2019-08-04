import { Component, OnInit } from '@angular/core';
import { StoryDetail } from 'src/app/domain/models/story/story-detail';
import { ActivatedRoute } from '@angular/router';
import { StoryService } from '../story.module.service';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
  styleUrls: ['./story-detail.component.scss']
})
export class StoryDetailComponent implements OnInit {

  public story: StoryDetail;
  public currentPlace: PlaceDetail;
  //opened: boolean;
  constructor(private _activatedRoute: ActivatedRoute, private storyService: StoryService) { }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      let id = params['id'];
      this.storyService.getStoryInfoById(id).subscribe(
        response => (this.story = response, this.currentPlace = this.story.places[0])  
      )
    });
  }

}
