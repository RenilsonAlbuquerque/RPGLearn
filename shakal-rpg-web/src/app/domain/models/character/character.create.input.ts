import { KeyValue } from '../comon/key.value';
import { CharacterClassInput } from './character.class.input';
import { CharacterRaceInput } from './character.race.input';

export interface CharacterCreateInput{
    
    races: CharacterRaceInput[],
    classes: CharacterClassInput[],
    alignments: KeyValue[],
    damageType: KeyValue[],
    languages: KeyValue[],

}