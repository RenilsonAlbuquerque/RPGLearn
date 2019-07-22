import { KeyValue } from '../comon/key.value';

export interface MonsterCreate{
    raceName: string,
    raceDescription: string;
    imagePath: string,
    level: KeyValue
    damageImunity: KeyValue[],
    damageResistence: KeyValue[]
    langauges: KeyValue[]


}