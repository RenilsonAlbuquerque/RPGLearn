import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CombatMenuComponent } from './combat-menu/combat-menu.component';
import { CombatRoutingModule } from './combat.module.router';
import { CombatScreenComponent } from './combat-screen/combat-screen.component';
import { MonsterModule } from '../monster/monster.module';
import { NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MonsterService } from '../monster/monster.module.service';
import { MaterialModule } from '../material-design/material.module';
import { CombatRoomService } from './services/combat-room.service';
import { InjectableRxStompConfig, RxStompService, rxStompServiceFactory } from '@stomp/ng2-stompjs';
import { myRxStompConfig } from 'src/app/infra/config/my-rx-stomp.config';
import { GridBoardComponent } from './grid-board/grid-board.component';
import { GridBoardCardComponent } from './grid-board-card/grid-board-card.component';
import { CombatScreenPlayerComponent } from './combat-screen-player/combat-screen-player.component';
import { CombatRoomPlayerService } from './services/combat-room.player.service';
import { GridBoardService } from './services/grid-board.service';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { DragScrollModule } from 'ngx-drag-scroll';



@NgModule({
  declarations: [CombatMenuComponent, CombatScreenComponent, GridBoardComponent, GridBoardCardComponent, CombatScreenPlayerComponent],
  imports: [
    CombatRoutingModule,
    CommonModule,
    MonsterModule,
    NgbModalModule,
    MaterialModule,
    NgbModule,
    DragDropModule,
    DragScrollModule

  ],
  providers:[
    MonsterService,
    CombatRoomService,
    CombatRoomPlayerService,
    GridBoardService,
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
  exports:[GridBoardComponent, CombatScreenPlayerComponent]
})
export class CombatModule { }
