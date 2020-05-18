import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { D20Component } from './d20/d20.component';
import { DiceRollContainerComponent } from './dice-roll-container/dice-roll-container.component';
import { DiceService } from './dice.module.service';
import { InsertionDirective } from 'src/app/infra/directives/insert-component.directive';
import { D10Component } from './d10/d10.component';
import { D8Component } from './d8/d8.component';
import { D6Component } from './d6/d6.component';
import { D4Component } from './d4/d4.component';
import { D12Component } from './d12/d12.component';
import { DiceMasterMenuComponent } from './dice-master-menu/dice-master-menu.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';

import { faDiceD20 } from '@fortawesome/free-solid-svg-icons';
import { library } from '@fortawesome/fontawesome-svg-core';

@NgModule({
  declarations: [D20Component, DiceRollContainerComponent,InsertionDirective, D10Component, D8Component, D6Component, D4Component, D12Component, DiceMasterMenuComponent],
  imports: [
    CommonModule,
    FontAwesomeModule
  ],
  exports:[DiceRollContainerComponent,DiceMasterMenuComponent],
  providers:[DiceService],
  entryComponents: [D20Component,D12Component,D10Component,D8Component,D6Component,D4Component]
})
export class DiceModule { 
  constructor(){
    library.add(faDiceD20);
  }
}
