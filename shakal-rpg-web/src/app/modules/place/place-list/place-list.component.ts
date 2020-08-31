import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PlaceService } from '../place.module.service';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';

@Component({
  selector: 'app-place-list',
  templateUrl: './place-list.component.html',
  styleUrls: ['./place-list.component.scss']
})
export class PlaceListComponent implements OnInit {

  private modalReference;
  private placesList: PlaceOverview[];
  storyid: number;
  constructor(private _activatedRoute: ActivatedRoute, private placeService: PlaceService,private modalService: NgbModal) { }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      this.storyid = params['id'];
      this.placeService.getOverview(this.storyid).subscribe(
        result => {this.placesList = result},
        err =>{console.log(err) }
      );
    });
  }
  openCreatePlace(content){
    this.modalReference = this.modalService.open(content, {size: 'xl'});
  }
  addPlaceOnMap(place: PlaceOverview){
    this.placesList.push({
      id: place.id,
      name: place.name,
      folderImage: place.folderImage
    } as PlaceOverview);
    
    this.modalReference.dismiss();
  }

}
