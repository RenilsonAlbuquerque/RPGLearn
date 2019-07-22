import { KeyValue } from '../comon/key.value';
import { NameDescription } from '../comon/name-description';

export interface MonsterCreate{
    raceName: string,
    raceDescription: string;
    imagePath: string,
    alignment: KeyValue,
    size: KeyValue,
    type: NameDescription,
    armorClass: number,
    lifePoints: number,
    force:number,
    dexterity:number,
    constitution:number,
    inteligence:number,
    wisdom: number,
    charisma: number,
    level: KeyValue
    damageImunity: KeyValue[],
    damageResistence: KeyValue[]
    langauges: KeyValue[],
    features: NameDescription[]


}