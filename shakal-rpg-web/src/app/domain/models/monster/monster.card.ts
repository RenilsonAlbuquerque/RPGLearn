import { KeyValue } from '../comon/key.value';
import { Level } from '../comon/level';

export interface MonsterCard{
    id: number,
    name: String,
    level: Level,
    lifePoints: number,
    totalLifePoints: number,
    imagePath: string,
    lifePercent: number
}