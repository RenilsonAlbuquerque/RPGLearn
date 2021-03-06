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
import { StoryCreateComponent } from './story-create/story-create.component';
import { FormsModule, ReactiveFormsModule, FormBuilder } from '@angular/forms';
import { BasecomponentsModule } from '../basecomponents/basecomponents.module';
import { PlaceCreateComponent } from './place-create/place-create.component';
import { StoryDetailPlayerComponent } from './story-detail-player/story-detail-player.component';
import { CombatModule } from '../combat/combat.module';
import { CharacterService } from '../character/character.module.service';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { PlaceMakerComponent } from './place-maker/place-maker.component';
import { PlaceModule } from '../place/place.module';
import { UserService } from '../user/user.module.service';




@NgModule({
  declarations: [StoryMapComponent, PlaceDetailComponent, StoryListComponent, StoryDetailComponent, PlaceOverviewComponent, StoryCreateComponent, PlaceCreateComponent, StoryDetailPlayerComponent, PlaceMakerComponent],
  imports: [
    CommonModule,
    StoryRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BasecomponentsModule,
    CombatModule,
    FontAwesomeModule,
    PlaceModule
  ],
  providers:[StoryService,FormBuilder,CharacterService,UserService]
})
export class StoryModule { }
