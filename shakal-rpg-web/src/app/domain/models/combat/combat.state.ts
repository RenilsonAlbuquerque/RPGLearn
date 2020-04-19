import { CreatureCard } from '../monster/creature.card';

export interface CombatState{
    creatures: CreatureCard[],
    dificult: number
    userTypeInStory: number;
}
