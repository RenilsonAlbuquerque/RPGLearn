import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MonsterListComponent } from './monster-list/monster-list.component';
import { MonsterRoutingModule } from './monster.module.router';
import { MonsterService } from './monster.module.service';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { MonsterDetailComponent } from './monster-detail/monster-detail.component';
import { MonsterInfoComponent } from './monster-info/monster-info.component';
import { MonsterSheetComponent } from './monster-sheet/monster-sheet.component';
import { MonsterCardComponent } from './monster-card/monster-card.component';



@NgModule({
  declarations: [MonsterListComponent, MonsterDetailComponent, MonsterInfoComponent, MonsterSheetComponent, MonsterCardComponent],
  imports: [
    CommonModule,
    MonsterRoutingModule,
    NgbPaginationModule
  ],
  providers:[
    MonsterService
  ],
  exports: [MonsterCardComponent] 
})
export class MonsterModule { }
