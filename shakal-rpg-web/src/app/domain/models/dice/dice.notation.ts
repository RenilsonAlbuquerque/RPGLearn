import { DiceNumber } from './dice.number';

export interface DiceNotation{
    quantity:number,
    dice: DiceNumber,
    bonus: number,
    result: number,
}