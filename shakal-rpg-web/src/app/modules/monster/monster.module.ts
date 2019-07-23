import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MonsterListComponent } from './monster-list/monster-list.component';
import { MonsterRoutingModule } from './monster.module.router';
import { MonsterService } from './monster.module.service';
import { NgbPaginationModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { MonsterDetailComponent } from './monster-detail/monster-detail.component';
import { MonsterInfoComponent } from './monster-info/monster-info.component';
import { MonsterSheetComponent } from './monster-sheet/monster-sheet.component';
import { MonsterCardComponent } from './monster-card/monster-card.component';
import { MonsterSearchCardComponent } from './monster-search-card/monster-search-card.component';
import { MonsterCreateComponent } from './monster-create/monster-create.component';


import { FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from '../material-design/material.module';
import { BasecomponentsModule } from '../basecomponents/basecomponents.module';




@NgModule({
  declarations: [MonsterListComponent, MonsterDetailComponent, MonsterInfoComponent, MonsterSheetComponent, MonsterCardComponent, MonsterSearchCardComponent, MonsterCreateComponent],
  imports: [
    NgbModalModule,
    CommonModule,
    MonsterRoutingModule,
    NgbPaginationModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BasecomponentsModule
  ],
  providers:[
    MonsterService,FormBuilder
  ],
  exports: [MonsterCardComponent,MonsterSearchCardComponent, MonsterSheetComponent] 
})
export class MonsterModule { }
