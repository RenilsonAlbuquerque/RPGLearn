import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StoryMapComponent } from './story-map/story-map.component';
import { StoryRoutingModule } from './story.module.routing';



@NgModule({
  declarations: [StoryMapComponent],
  imports: [
    CommonModule,
    StoryRoutingModule
  ]
})
export class StoryModule { }
