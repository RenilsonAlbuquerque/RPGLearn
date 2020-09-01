import { Component, OnInit, Input, TemplateRef } from '@angular/core';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { CombatRoomService } from '../../combat/services/combat-room.service';
import { GridBoardService } from '../../combat/services/grid-board.service';
import { PlaceService } from '../place.module.service';

@Component({
  selector: 'app-place-list-card',
  templateUrl: './place-list-card.component.html',
  styleUrls: ['./place-list-card.component.scss']
})
export class PlaceListCardComponent implements OnInit {

  @Input()
  private place: PlaceOverview;
  constructor(private modalService: NgbModal,private internModalService: InternModalService,
    private combatRoomService: CombatRoomService, private gridBoardService: GridBoardService,private placeService: PlaceService) { }

  ngOnInit() {
  }
  onOpenPlaceDetails(templatePlace: TemplateRef<any>){
      this.internModalService.openMediumModal(templatePlace);  
  }
  selectAsCurrentPlace(){
    this.combatRoomService.updateMapOfCombat(this.place.id);
    this.placeService.getDetail(this.place.id).subscribe(
      place => {
        this.gridBoardService.updateMap(place);
    });
    this.internModalService.closeModalReference();
  }
}
