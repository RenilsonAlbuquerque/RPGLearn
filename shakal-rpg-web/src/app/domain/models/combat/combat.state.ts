import { MonsterCard } from '../monster/monster.card';

export interface CombatState{
    monsters: MonsterCard[],
    players: MonsterCard[],
    dificult: number
    userTypeInStory: number;
}
