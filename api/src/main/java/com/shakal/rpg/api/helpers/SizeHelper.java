package com.shakal.rpg.api.helpers;

import com.shakal.rpg.api.model.creature.CreatureSize;

public class SizeHelper {
	
	public static double getCreatureSizeInSquare(CreatureSize creatureSize) {
		double result = 1;
		if(creatureSize.getId() == 1) {
			result = 0.5;
		}
		if(creatureSize.getId() == 2 || creatureSize.getId() == 3) {
			result = 1;
		}
		if(creatureSize.getId() == 4) {
			result = 2;
		}
		if(creatureSize.getId() == 5) {
			result = 3;
		}
		if(creatureSize.getId() == 6) {
			result = 4;
		}
		return result;
	}

}
