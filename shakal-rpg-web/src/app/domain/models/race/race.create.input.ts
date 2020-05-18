import { RaceAtributeBonus } from './race.atribute.bonus';
import { KeyValue } from '../comon/key.value';

export interface RaceCreateInput{
    description:string,
    speed: number,
    alignmentDescription: string,
    atributeBonus:RaceAtributeBonus[],
    ageDescription: string,
    sizeDescription: string,
    languages: KeyValue[],
}