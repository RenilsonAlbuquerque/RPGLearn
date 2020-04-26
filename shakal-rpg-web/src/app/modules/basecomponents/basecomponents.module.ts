import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InputChipComponent } from './input-chip/input-chip.component';
import { MaterialModule } from '../material-design/material.module';
import { FormsModule, FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { SystemModalComponent } from './system-modal/system-modal.component';



@NgModule({
  declarations: [InputChipComponent, SystemModalComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [InputChipComponent],
  providers:[
    FormBuilder
  ]
})
export class BasecomponentsModule { }
