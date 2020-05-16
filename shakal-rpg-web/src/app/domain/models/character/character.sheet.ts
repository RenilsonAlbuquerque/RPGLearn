import { ClassLevelDetail } from '../class/class.level.detail';
import { KeyValue } from '../comon/key.value';
import { CharacterLifePoints } from './character.life.points';
import { CreatureAtribute } from '../creature/creature.atribute';

export interface CharacterSheet{
    id: number,
    userId: number,

    name: string,
    background: string,

    classLevels:ClassLevelDetail[],
    race: KeyValue,
    alignment: KeyValue,
    experiencyPoints: number,
    player: KeyValue,

    strength:CreatureAtribute,
    dexterity:CreatureAtribute,
    constitution:CreatureAtribute,
    wisdom:CreatureAtribute,
    inteligence:CreatureAtribute,
    charisma:CreatureAtribute,

    proeficiencies:number[],

    languages: KeyValue[],

    proeficiencBonus: number,
    
    age: number,
    height: number,
    weight: number,
    imagePath: string,
    
    lifePoints:CharacterLifePoints,


    armorClass:number,
    initiative:number,
    speed:number

    
}