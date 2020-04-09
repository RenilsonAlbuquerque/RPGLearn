import { CharacterSheet } from './character.sheet';
import { MonsterCard } from '../monster/monster.card';

export interface CharacterInfo{
    characterSheet: CharacterSheet,
    characterToken: MonsterCard
}