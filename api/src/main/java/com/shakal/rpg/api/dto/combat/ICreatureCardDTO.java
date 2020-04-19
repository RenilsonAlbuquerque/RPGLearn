package com.shakal.rpg.api.dto.combat;

import com.shakal.rpg.api.dto.info.LevelDTO;

public interface ICreatureCardDTO extends  Comparable<ICreatureCardDTO>{
	
	public long getId();
	public String getName();
	public int getLifePoints();
	public LevelDTO getLevel();
	public int getLifePercent();
	public void setLifePercent(int lifePercent);
	public int getTotalLifePoints();
	public int getSpeed();
	public String getImagePath();
	public CardPositionDTO getPosition();

}
