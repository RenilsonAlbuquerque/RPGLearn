package com.shakal.rpg.api.contracts;

import com.shakal.rpg.api.model.Atribute;

public interface ICreature {
	
	Atribute getForce();
	Atribute getDexterity();
	Atribute getConstitution();
	Atribute getInteligence();
	Atribute getWisdom();
	Atribute getCharisma();

}
