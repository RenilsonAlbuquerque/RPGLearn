package com.shakal.rpg.api.helpers;

public class CombatHelper {

	public static int calculateLifePercent(int totalLifePoints, int currentLifePoints) {
		return (100 * currentLifePoints)/ totalLifePoints;
	}
}
