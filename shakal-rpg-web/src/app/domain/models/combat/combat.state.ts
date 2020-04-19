import { CreatureCard } from '../monster/creature.card';

export interface CombatState{
    creatures: CreatureCard[],
    allyQueue: CreatureCard[],
    enemyQueue: CreatureCard[],
    dificult: number,
    userTypeInStory: number;
}
