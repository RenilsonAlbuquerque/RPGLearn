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
import { CombatRoomService } from '../combat/services/combat-room.service';
import { OnlynumberDirective } from 'src/app/infra/directives/only-number.directive';
import { InjectableRxStompConfig, RxStompService, rxStompServiceFactory } from '@stomp/ng2-stompjs';
import { myRxStompConfig } from 'src/app/infra/config/my-rx-stomp.config';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MonsterDragableListComponent } from './monster-dragable-list/monster-dragable-list.component';




@NgModule({
  declarations: [MonsterListComponent, MonsterDetailComponent, MonsterInfoComponent,
     MonsterSheetComponent, MonsterCardComponent, MonsterSearchCardComponent, 
     MonsterCreateComponent,OnlynumberDirective, MonsterDragableListComponent],
  imports: [
    NgbModalModule,
    CommonModule,
    MonsterRoutingModule,
    NgbPaginationModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    BasecomponentsModule,
    FontAwesomeModule
  ],
  providers:[
    MonsterService,FormBuilder,CombatRoomService,
    {
      provide: InjectableRxStompConfig,
      useValue: myRxStompConfig
    },
    {
      provide: RxStompService,
      useFactory: rxStompServiceFactory,
      deps: [InjectableRxStompConfig]
    }
  ],
  exports: [MonsterCardComponent,MonsterSearchCardComponent, MonsterSheetComponent,MonsterDragableListComponent] 
})
export class MonsterModule { }
