import { Component, OnInit, Input } from '@angular/core';
import { PlaceMarker } from 'src/app/domain/models/comon/place-marker';

@Component({
  selector: 'app-place-detail',
  templateUrl: './place-detail.component.html',
  styleUrls: ['./place-detail.component.scss']
})
export class PlaceDetailComponent implements OnInit {

  @Input() public place: PlaceMarker;
  constructor() { }

  ngOnInit() {
  }

}
