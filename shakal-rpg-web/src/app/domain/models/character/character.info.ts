import { CharacterSheet } from './character.sheet';
import { CreatureCard } from '../monster/creature.card';

export interface CharacterInfo{
    characterSheet: CharacterSheet,
    characterToken: CreatureCard
}