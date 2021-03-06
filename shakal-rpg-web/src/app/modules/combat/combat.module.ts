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

import { faRunning,faWalking,faPlus,faMinus, faDice, faUser,faTimes, faUserCog, faCog, faForward, faFileAlt, faPlay, faTrash } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { DiceModule } from '../dice/dice.module';
import { CombaatTurnOrderComponent } from './combaat-turn-order/combaat-turn-order.component';
import { CombatCounterComponent } from './combat-counter/combat-counter.component';
import { MasterMenuControlComponent } from './master-menu-control/master-menu-control.component';
import { InternModalService } from 'src/app/infra/services/intern.modal.service';
import { CharacterModule } from '../character/character.module';
import { WeaponModule } from '../weapon/weapon.module';
import { StoryModule } from '../story/story.module';
import { PlaceModule } from '../place/place.module';
import { PlayerMenuControlComponent } from './player-menu-control/player-menu-control.component';
//import {MatTab} from '@angular/material/tabs'



@NgModule({
  declarations: [CombatMenuComponent, CombatScreenComponent, GridBoardComponent, GridBoardCardComponent, CombatScreenPlayerComponent, CombaatTurnOrderComponent, CombatCounterComponent, MasterMenuControlComponent, PlayerMenuControlComponent],
  imports: [
    CombatRoutingModule,
    CommonModule,
    MonsterModule,
    PlaceModule,
    NgbModalModule,
    MaterialModule,
    NgbModule,
    DragDropModule,
    DragScrollModule,
    FontAwesomeModule,
    DiceModule,
    CharacterModule,
    WeaponModule
  ],
  providers:[
    MonsterService,
    CombatRoomService,
    CombatRoomPlayerService,
    FontAwesomeModule,
    GridBoardService,
    InternModalService,
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
export class CombatModule {
  constructor(){
    library.add(faRunning,faWalking,faPlus,faDice,faUser,
      faTimes,faUserCog,faCog,faMinus, faForward, faFileAlt,faPlay,faTrash);
  }
}
