import { Injectable } from '@angular/core';
import { DiceNotation } from 'src/app/domain/models/dice/dice.notation';
import { BehaviorSubject } from 'rxjs';
import { DiceComponent } from 'src/app/domain/models/dice/dice.component';


@Injectable()
export class DiceService {
    private currentDice: BehaviorSubject<DiceNotation[]>;
    private dices : DiceComponent[];
    constructor(){
        this.dices = [];
        this.currentDice = new BehaviorSubject<DiceNotation[]>([] as DiceNotation[]);
    }
    getCurrentDice(){
        return this.currentDice;
    }
    addDicesToQueue(currentDice: DiceNotation[]){
        this.currentDice.next(currentDice);
    }
    addDiceCOmponentToRoll(dice:DiceComponent){
        this.dices.push(dice);
    }
    rollDicesinQueue(){
        this.dices.forEach(dice =>{
            dice.roll();
        });
    }
}