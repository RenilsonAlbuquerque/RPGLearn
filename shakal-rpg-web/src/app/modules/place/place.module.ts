import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlaceListComponent } from './place-list/place-list.component';
import { PlaceListCardComponent } from './place-list-card/place-list-card.component';
import { PlaceService } from './place.module.service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { StoryModule } from '../story/story.module';
import { PlaceCreateComponent } from './place-create/place-create.component';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material-design/material.module';
import { GridBoardService } from '../combat/services/grid-board.service';


@NgModule({
  declarations: [PlaceListComponent, PlaceListCardComponent, PlaceCreateComponent],
  imports: [
    CommonModule,
    FontAwesomeModule,
    FormsModule,
    ReactiveFormsModule,
    MaterialModule
  ],
  exports:[PlaceListComponent,PlaceListCardComponent],
  providers:[PlaceService,FormBuilder,GridBoardService]
})
export class PlaceModule { }
