package com.shakal.rpg.api.contracts.entity;

import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.model.relation.CreatureAtribute;

public interface ICreature {
	
	CreatureAtribute getForce();
	CreatureAtribute getDexterity();
	CreatureAtribute getConstitution();
	CreatureAtribute getInteligence();
	CreatureAtribute getWisdom();
	CreatureAtribute getCharisma();

}
