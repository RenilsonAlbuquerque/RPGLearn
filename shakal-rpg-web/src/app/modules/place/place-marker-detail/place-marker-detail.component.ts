import { Component, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { EventEmitter } from 'protractor';
import { PlaceMarkCreate } from 'src/app/domain/models/place/place.mark.create';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { PlaceService } from '../place.module.service';

@Component({
  selector: 'app-place-marker-detail',
  templateUrl: './place-marker-detail.component.html',
  styleUrls: ['./place-marker-detail.component.scss']
})
export class PlaceMarkerDetailComponent implements OnInit {

  @Input()
  private placeId: number;
  @Input()
  private coordinateX: number;
  @Input()
  private coordinateY: number;
  public markDetailForm: FormGroup;

  //@Output() addMarker = new EventEmitter();

  constructor(private formBuilder: FormBuilder, private placeService: PlaceService,
    private toastr: ToastrService,private internModalService: InternModalService) { 
    

  }

  ngOnInit() {
    this.markDetailForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required]
    });
  }
  onSubmit(){
    let entity = {
      name: this.markDetailForm.controls['name'].value,
      description: this.markDetailForm.controls['description'].value,
      coordinateX: this.coordinateX,
      coordinateY: this.coordinateY,
      placeId: this.placeId
    } as PlaceMarkCreate;
    this.placeService.createPlaceMark(entity).subscribe(
      response => {this.toastr.success("Marcador cadastrado com sucesso"), 
        this.internModalService.closeModalReference();
    },
      //this.adcionarLugar.emit(response)),
      error => (this.toastr.error(error)) 
    );
  }

}
