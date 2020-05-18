import { KeyValue } from '../comon/key.value';
import { ProeficiencyChoose } from './proeficeincy.choose';

export interface ClassCreateInput{
    description:string,
    lifeDice:string,
    savingThrows: KeyValue[],
    proeficiencyChoose: ProeficiencyChoose
}