import { ClassLevelDetail } from '../class/class.level.detail';
import { KeyValue } from '../comon/key.value';
import { CharacterLifePoints } from './character.life.points';
import { CreatureAtribute } from '../creature/creature.atribute';
import { ViewAtributeInfo } from './character.view.atribute';

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

    savins: ViewAtributeInfo[],
    proeficiencies:ViewAtributeInfo[],

    languages: KeyValue[],

    inspiration: number,
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