import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CharacterCreateComponent } from './character-create/character-create.component';
import { CharacterRoutingModule } from './character.module.routing';
import { MaterialModule } from '../material-design/material.module';
import { CharacterService } from './character.module.service';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CharacterSheetComponent } from './character-sheet/character-sheet.component';
import { RaceService } from 'src/app/infra/services/race.service';



@NgModule({
  declarations: [CharacterCreateComponent, CharacterSheetComponent],
  imports: [
    CommonModule,
    CharacterRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers:[CharacterService,FormBuilder,RaceService],
  exports: [CharacterSheetComponent]
})
export class CharacterModule { }
