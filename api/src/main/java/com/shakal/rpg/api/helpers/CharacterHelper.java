package com.shakal.rpg.api.helpers;

import com.shakal.rpg.api.model.Dice;

public class CharacterHelper {

	public static int calculateLifePoints(Dice lifeDice) {
		int result = 0;
		if(lifeDice.getId() == 1) {
			result = 4;
		}
		if(lifeDice.getId() == 2) {
			result = 6;
		}
		if(lifeDice.getId() == 3) {
			result = 8;
		}
		if(lifeDice.getId() == 4) {
			result = 10;
		}
		if(lifeDice.getId() == 5) {
			result = 12;
		}
		if(lifeDice.getId() == 6) {
			result = 20;
		}
		return result;
		
	}
}
