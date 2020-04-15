import { ActionType } from './action.type';
import { MonsterCard } from '../monster/monster.card';

export interface ActionControl{
    creature:MonsterCard,
    actionType: ActionType,
}