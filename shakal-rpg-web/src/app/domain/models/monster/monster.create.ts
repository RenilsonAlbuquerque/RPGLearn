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
    proeficientForce: boolean,
    dexterity:number,
    proeficientDexterity: boolean,
    constitution:number,
    proeficientConstitution: boolean,
    inteligence:number,
    proeficientInteligence: boolean,
    wisdom: number,
    proeficientWisdom: boolean,
    charisma: number,
    proeficientCharisma: boolean,
    level: number,
    damageImunity: KeyValue[],
    damageResistence: KeyValue[]
    languages: KeyValue[],
    features: NameDescription[]


}