import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MonsterListComponent } from './monster-list/monster-list.component';
import { MonsterRoutingModule } from './monster.module.router';
import { MonsterService } from './monster.module.service';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';



@NgModule({
  declarations: [MonsterListComponent],
  imports: [
    CommonModule,
    MonsterRoutingModule,
    NgbPaginationModule
  ],
  providers:[
    MonsterService
  ]
})
export class MonsterModule { }
