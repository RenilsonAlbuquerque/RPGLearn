import { Component, OnInit, Input } from '@angular/core';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-place-overview',
  templateUrl: './place-overview.component.html',
  styleUrls: ['./place-overview.component.scss']
})
export class PlaceOverviewComponent implements OnInit {

  @Input() public place: PlaceDetail;

  constructor() { 
    
  }

  ngOnInit() {
   
  }

}
