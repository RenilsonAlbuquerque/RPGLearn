import { ActionType } from './action.type';
import { CreatureCard } from '../monster/creature.card';

export interface ActionControl{
    creature:CreatureCard,
    actionType: ActionType,
}