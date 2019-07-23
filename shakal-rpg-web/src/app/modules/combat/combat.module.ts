import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CombatMenuComponent } from './combat-menu/combat-menu.component';
import { CombatRoutingModule } from './combat.module.router';
import { CombatScreenComponent } from './combat-screen/combat-screen.component';
import { MonsterCardComponent } from '../monster/monster-card/monster-card.component';
import { MonsterModule } from '../monster/monster.module';
import { NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { MonsterService } from '../monster/monster.module.service';
import { MaterialModule } from '../material-design/material.module';



@NgModule({
  declarations: [CombatMenuComponent, CombatScreenComponent],
  imports: [
    CombatRoutingModule,
    CommonModule,
    MonsterModule,
    NgbModalModule,
    MaterialModule
  ],
  providers:[
    MonsterService
  ]
})
export class CombatModule { }
