import { KeyValue } from '../comon/key.value';
import { CostInfo } from '../economy/cost.info';
import { DamageInfo } from '../damage/damage.info';

export interface WeaponInfo{
    id: number,
    imagePath:string,
    name: string,
    description: string,
    weight: number,
    rarity: KeyValue,
    cost: CostInfo,
    category: KeyValue,
    classification: KeyValue,
    range: KeyValue,
    damage: DamageInfo[],
    bonus: number,
    
}