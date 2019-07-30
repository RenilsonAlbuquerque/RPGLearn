import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoryMapComponent } from './story-map/story-map.component';
import { StoryRoutingModule } from './story.module.routing';
import { PlaceDetailComponent } from './place-detail/place-detail.component';
import { MaterialModule } from '../material-design/material.module';



@NgModule({
  declarations: [StoryMapComponent, PlaceDetailComponent],
  imports: [
    CommonModule,
    StoryRoutingModule,
    MaterialModule
  ]
})
export class StoryModule { }
