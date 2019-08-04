import { Component, OnInit, Input } from '@angular/core';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';

@Component({
  selector: 'app-place-overview',
  templateUrl: './place-overview.component.html',
  styleUrls: ['./place-overview.component.scss']
})
export class PlaceOverviewComponent implements OnInit {

  @Input() public place: PlaceDetail;
  constructor() { }

  ngOnInit() {
    console.log(this.place)
  }

}
