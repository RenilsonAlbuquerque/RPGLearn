import { KeyValue } from '../comon/key.value';
import { NameDescription } from '../comon/name-description';

export interface MonsterCreate{
    raceName: string,
    raceDescription: string;
    imagePath: string,
    alignment: number,
    size: number,
    type: number,
    armorClass: number,
    lifePoints: number,
    force:number,
    dexterity:number,
    constitution:number,
    inteligence:number,
    wisdom: number,
    charisma: number,
    level: number,
    damageImunity: KeyValue[],
    damageResistence: KeyValue[]
    langauges: KeyValue[],
    features: NameDescription[]


}