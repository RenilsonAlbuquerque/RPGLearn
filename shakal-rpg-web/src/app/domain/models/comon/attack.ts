import { DamageDice } from './damage.dice';

export interface Attack{
    name: String,
    description: string,
    damages: DamageDice[]
}