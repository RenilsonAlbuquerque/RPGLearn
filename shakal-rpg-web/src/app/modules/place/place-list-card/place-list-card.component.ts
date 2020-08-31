import { Component, OnInit, Input } from '@angular/core';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';

@Component({
  selector: 'app-place-list-card',
  templateUrl: './place-list-card.component.html',
  styleUrls: ['./place-list-card.component.scss']
})
export class PlaceListCardComponent implements OnInit {

  @Input()
  private place: PlaceOverview;
  constructor() { }

  ngOnInit() {
  }

}
