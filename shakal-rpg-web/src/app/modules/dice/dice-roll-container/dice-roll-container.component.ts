import { Component, OnInit, ComponentFactoryResolver, ComponentFactory,ViewChild,ViewContainerRef, Type, ElementRef, TemplateRef, Directive, ViewRef } from '@angular/core';
import { DiceComponent } from 'src/app/domain/models/dice/dice.component';
import { DiceService } from '../dice.module.service';
import { DiceNotation } from 'src/app/domain/models/dice/dice.notation';
import { DiceNumber } from 'src/app/domain/models/dice/dice.number';
import { D20Component } from '../d20/d20.component';
import { InsertionDirective } from 'src/app/infra/directives/insert-component.directive';
import { D12Component } from '../d12/d12.component';
import { D10Component } from '../d10/d10.component';
import { D8Component } from '../d8/d8.component';
import { D6Component } from '../d6/d6.component';
import { D4Component } from '../d4/d4.component';


@Component({
  selector: 'app-dice-roll-container',
  templateUrl: './dice-roll-container.component.html',
  styleUrls: ['./dice-roll-container.component.scss']
})
export class DiceRollContainerComponent implements OnInit {

  @ViewChild('dynamicComponent', { read: ViewContainerRef, static:true }) myRef


  private dices: DiceComponent[];
  private queue: DiceNotation[];


  constructor(private resolver: ComponentFactoryResolver,private diceService: DiceService) { 
    this.dices = [];
    
    this.diceService.getInitiativeQueue().subscribe(
      result => {
        this.queue = result;
        //this.diceService.clearInitiativeQueue();
        this.ngOnInit();
        
      }
    );
  }

  ngOnInit() {
    this.changeDices(this.queue);
  }
  changeDices(dices: DiceNotation[]){
    if(this.myRef){
      dices.forEach(diceNotation => {
        for(let i = 0; i < diceNotation.quantity; i++){
          if(diceNotation.dice === DiceNumber.d20.valueOf()){
            this.instantiateComponent(D20Component, diceNotation.result)
          }
          if(diceNotation.dice === DiceNumber.d12.valueOf()){
            this.instantiateComponent(D12Component,diceNotation.result);
          }
          if(diceNotation.dice === DiceNumber.d10.valueOf()){
            this.instantiateComponent(D10Component,diceNotation.result);
          }
          if(diceNotation.dice === DiceNumber.d8.valueOf()){
            this.instantiateComponent(D8Component,diceNotation.result);
          }
          if(diceNotation.dice === DiceNumber.d6.valueOf()){
            this.instantiateComponent(D6Component,diceNotation.result);
          }
          if(diceNotation.dice === DiceNumber.d4.valueOf()){
            this.instantiateComponent(D4Component,diceNotation.result);
          }
        }
      });
      
      this.rollAllPrefixedValue();
    }
  }
  instantiateComponent(component, result: number){
    const factory = this.resolver.resolveComponentFactory(component);
    const ref = this.myRef.createComponent(factory);
    ref._component.prefixedResult = result;
    this.dices.push(ref._component);
    ref.changeDetectorRef.detectChanges();

  }
  rollAll(){
    let result = 0;
    this.dices.forEach(dice =>{
       result += dice.roll();
    });
  }
  rollAllPrefixedValue(){
    this.dices.forEach(dice =>{
       dice.roll();
    });
  }
  close(){
    this.diceService.changeRolling(false);
    this.diceService.clearInitiativeQueue();
  }

}
