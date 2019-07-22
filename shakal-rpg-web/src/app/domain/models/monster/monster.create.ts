import { KeyValue } from '../comon/key.value';
import { NameDescription } from '../comon/name-description';

export interface MonsterCreate{
    raceName: string,
    raceDescription: string;
    imagePath: string,
    level: KeyValue
    damageImunity: KeyValue[],
    damageResistence: KeyValue[]
    langauges: KeyValue[],
    features: NameDescription[]


}