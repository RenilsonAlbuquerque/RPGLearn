import { Injectable } from '@angular/core';
import { DiceNotation } from 'src/app/domain/models/dice/dice.notation';
import { BehaviorSubject, Observable } from 'rxjs';
import { DiceComponent } from 'src/app/domain/models/dice/dice.component';
import { DiceNumber } from 'src/app/domain/models/dice/dice.number';
import { generateRandomFace } from 'src/app/infra/helpers/dice.helper';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';


@Injectable()
export class DiceService {
    private rolling: BehaviorSubject<boolean>;
    private currentDice: BehaviorSubject<DiceNotation[]>;
    private dices : DiceComponent[];
    private initiativeQueue:BehaviorSubject<DiceNotation[]>;
    constructor(){
        this.dices = [];
        this.rolling = new BehaviorSubject<boolean>(false);
        this.currentDice = new BehaviorSubject<DiceNotation[]>([] as DiceNotation[]);
        this.initiativeQueue = new BehaviorSubject<DiceNotation[]>([] as DiceNotation[]);
    }
    getCurrentDice(){
        return this.currentDice;
    }
    addDicesToQueue(currentDice: DiceNotation[]){
        this.currentDice.next(currentDice);
    }
    public clearInitiativeQueue(){
        this.initiativeQueue = new BehaviorSubject<DiceNotation[]>([] as DiceNotation[]);
        console.log(this.initiativeQueue);
    }
    public isRolling():Observable<boolean>{
        return this.rolling.asObservable();
    }
    public changeRolling(rolling: boolean){
        this.rolling.next(rolling);
    }
    public getInitiativeQueue():Observable<DiceNotation[]>{
        return this.initiativeQueue.asObservable();
    }
    public rollInitiativeOfCreatures(creatures: CreatureCard[]): CreatureCard[]{
        let dices:DiceNotation[] = [];
        let rollResult: number = 0;
        for(let i = 0; i<creatures.length;i++){
            rollResult = generateRandomFace(20);
            dices.push({quantity:1,dice:DiceNumber.d20,bonus:0,result:rollResult});
            creatures[i].initiative = rollResult;
        }
        this.rolling.next(true);
        this.initiativeQueue.next(dices);
        return creatures;
    }
    public rollInitiativeOfLeftCreatures(creatures: CreatureCard[]): CreatureCard[]{
        let creaturesLeft: CreatureCard[] = [];
        for(let i = 0; i<creatures.length;i++){
            if(creatures[i].initiative == 0){
                creaturesLeft.push(creatures[i]);
            }
        }
        return this.rollInitiativeOfCreatures(creaturesLeft);
    }
}