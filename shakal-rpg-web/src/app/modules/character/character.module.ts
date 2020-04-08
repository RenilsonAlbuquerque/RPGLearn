import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CharacterCreateComponent } from './character-create/character-create.component';
import { CharacterRoutingModule } from './character.module.routing';
import { MaterialModule } from '../material-design/material.module';
import { CharacterService } from './character.module.service';
import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [CharacterCreateComponent],
  imports: [
    CommonModule,
    CharacterRoutingModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers:[CharacterService,FormBuilder]
})
export class CharacterModule { }
