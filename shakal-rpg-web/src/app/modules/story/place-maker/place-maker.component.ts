import { Component, ElementRef, Input, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';

@Component({
  selector: 'app-place-maker',
  templateUrl: './place-maker.component.html',
  styleUrls: ['./place-maker.component.scss']
})
export class PlaceMakerComponent implements OnInit {

  @ViewChild('selfMarkerRef', { static: true })
  self: ElementRef<HTMLCanvasElement>;


  @Input()
  private placeId: number;

  @Input()
  private coordinateX: number;

  @Input()
  private coordinateY: number;
  constructor(private internModalService: InternModalService) {
    
  }

  ngOnInit() {
    this.self.nativeElement.style.top = this.coordinateY.toString() + "px";
    this.self.nativeElement.style.left = this.coordinateX.toString() + "px";
  }
  onClickDescription(templateMark: TemplateRef<any>){
    this.internModalService.openLargeModal(templateMark);
    
  }

}
