import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoryMapComponent } from './story-map/story-map.component';
import { StoryRoutingModule } from './story.module.routing';
import { PlaceDetailComponent } from './place-detail/place-detail.component';
import { MaterialModule } from '../material-design/material.module';
import { StoryListComponent } from './story-list/story-list.component';
import { StoryService } from './story.module.service';
import { StoryDetailComponent } from './story-detail/story-detail.component';
import { PlaceOverviewComponent } from './place-overview/place-overview.component';



@NgModule({
  declarations: [StoryMapComponent, PlaceDetailComponent, StoryListComponent, StoryDetailComponent, PlaceOverviewComponent],
  imports: [
    CommonModule,
    StoryRoutingModule,
    MaterialModule
  ],
  providers:[StoryService]
})
export class StoryModule { }
