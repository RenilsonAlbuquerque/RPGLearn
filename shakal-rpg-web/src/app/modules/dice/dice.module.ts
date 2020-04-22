import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { D20Component } from './d20/d20.component';
import { DiceRollContainerComponent } from './dice-roll-container/dice-roll-container.component';
import { DiceService } from './dice.module.service';
import { InsertionDirective } from 'src/app/infra/directives/insert-component.directive';
import { D10Component } from './d10/d10.component';
import { D8Component } from './d8/d8.component';
import { D6Component } from './d6/d6.component';



@NgModule({
  declarations: [D20Component, DiceRollContainerComponent,InsertionDirective, D10Component, D8Component, D6Component],
  imports: [
    CommonModule
  ],
  exports:[DiceRollContainerComponent],
  providers:[DiceService],
  entryComponents: [D20Component]
})
export class DiceModule { }
