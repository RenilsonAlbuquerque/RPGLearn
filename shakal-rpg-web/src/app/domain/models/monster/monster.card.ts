import { KeyValue } from '../comon/key.value';
import { Level } from '../comon/level';
import { CardPosition } from '../combat/card.position';

export interface MonsterCard{
    id: number,
    combatId: string,
    name: String,
    level: Level,
    lifePoints: number,
    totalLifePoints: number,
    imagePath: string,
    lifePercent: number,
    position: CardPosition
    playerId: number;
    speed:number,
    size:number
}