import { Component, OnInit, ComponentFactoryResolver, ComponentFactory,ViewChild,ViewContainerRef, Type, ElementRef, TemplateRef, Directive } from '@angular/core';
import { DiceComponent } from 'src/app/domain/models/dice/dice.component';
import { DiceService } from '../dice.module.service';
import { DiceNotation } from 'src/app/domain/models/dice/dice.notation';
import { DiceNumber } from 'src/app/domain/models/dice/dice.number';
import { D20Component } from '../d20/d20.component';
import { InsertionDirective } from 'src/app/infra/directives/insert-component.directive';


@Component({
  selector: 'app-dice-roll-container',
  templateUrl: './dice-roll-container.component.html',
  styleUrls: ['./dice-roll-container.component.scss']
})
export class DiceRollContainerComponent implements OnInit {

  //@ViewChild("AdDirective") container:ElementRef;
 

  @ViewChild(InsertionDirective, {static: true})
  insertionPoint: InsertionDirective;
  private rolling: boolean;
  private dices: DiceComponent[];
  private diceQueue: DiceNotation[];


  constructor(private resolver: ComponentFactoryResolver,private diceService: DiceService) { 
    this.rolling = true;
    this.dices = [];
    this.diceService.getCurrentDice().subscribe(
      queue => {
        this.changeDices(queue);
      }
    )
  }

  ngOnInit() {
  }
  rollDices(){
    this.dices.forEach( dice =>{
      dice.roll();
    })
  }
  changeDices(dices: DiceNotation[]){
    dices.forEach(diceNotation => {
      for(let i = 0; i < diceNotation.quantity; i++){
        console.log(diceNotation)
        if(diceNotation.dice === DiceNumber.d20.valueOf()){
          //this.dices.push(new D20Component());
          this.instantiateComponent(D20Component)
        }
      }
    })
    this.instantiateComponent(D20Component)
    //const factory: ComponentFactory = this.resolver.resolveComponentFactory(AlertComponent)
  }
  instantiateComponent(component){
    
    const factory = this.resolver.resolveComponentFactory(D20Component);
    const viewContainerRef = this.insertionPoint.viewContainerRef;
    viewContainerRef.clear();
    //let componentRef = this.insertionPoint.createComponent(factory);
    
    //this.componentRef.instance.type = type;
  }
  rollAll(){
    this.diceService.rollDicesinQueue();
  }

}
