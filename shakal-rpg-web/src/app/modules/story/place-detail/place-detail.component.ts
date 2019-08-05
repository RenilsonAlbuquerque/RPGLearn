import { Component, OnInit, Input } from '@angular/core';
import { PlaceMarker } from 'src/app/domain/models/comon/place-marker';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { Router, ActivatedRoute } from '@angular/router';
import { StoryService } from '../story.module.service';

@Component({
  selector: 'app-place-detail',
  templateUrl: './place-detail.component.html',
  styleUrls: ['./place-detail.component.scss']
})
export class PlaceDetailComponent implements OnInit {

  public place: PlaceDetail;
  constructor(private _activatedRoute: ActivatedRoute, private storyService: StoryService,
    private router: Router) { 
      this._activatedRoute.params.subscribe(params => {
        let id = params['id'];
        this.storyService.getPlaceInfoById(id).subscribe(
          response => (this.place = response)  
        )
      });
    }

  ngOnInit() {
   
  }
}
