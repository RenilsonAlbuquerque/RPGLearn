import { KeyValue } from '../comon/key.value';
import { KeyNameDescription } from '../comon/key.name.description';

export interface MonsterCreateInput{
    alignments: KeyValue[]
    sizes: KeyValue[],
    types: KeyNameDescription[]
    languages: KeyValue[],
    levels: KeyValue[],
    damageType: KeyValue[]
}