import { Component, OnInit } from '@angular/core';
import { StoryDetail } from 'src/app/domain/models/story/story-detail';
import { ActivatedRoute, Router } from '@angular/router';
import { StoryService } from '../story.module.service';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';

@Component({
  selector: 'app-story-detail',
  templateUrl: './story-detail.component.html',
  styleUrls: ['./story-detail.component.scss']
})
export class StoryDetailComponent implements OnInit {

  public story: StoryDetail;
  private storyid: number;
  
  //opened: boolean;
  constructor(private _activatedRoute: ActivatedRoute, private storyService: StoryService,
    private router: Router) { }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyid = params['id'];
      this.storyService.getStoryInfoById(this.storyid).subscribe(
        response => (this.story = response)  
      )
    });
  }
  goView(place){
    console.log(place)
    this.router.navigate(['home/story/place', place.id])
  }
  goToCombat(){
    this.router.navigate(['home/combat/screen/', this.storyid])
  }

}
