import { KeyValue } from '../comon/key.value';
import { NameDescription } from '../comon/name-description';
import { Attack } from '../comon/attack';

export interface MonsterCreate{
    raceName: string,
    raceDescription: string;
    imagePath: string,
    tokenImageRaw: string,
    alignment: number,
    size: number,
    type: number,
    armorClass: number,
    lifePoints: number,
    speed: number,
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
    features: NameDescription[],
    actions: Attack[],
    legendaryActions: Attack[]
}