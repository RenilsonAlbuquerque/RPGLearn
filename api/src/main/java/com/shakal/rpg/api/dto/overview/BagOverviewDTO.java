package com.shakal.rpg.api.dto.overview;

import java.util.List;

import com.shakal.rpg.api.dto.info.CostInfoDTO;

public class BagOverviewDTO {
	
	private List<CostInfoDTO> coins;
	private List<EquipmentOverviewDTO> equipment;
	
	
	public List<CostInfoDTO> getCoins() {
		return coins;
	}
	public void setCoins(List<CostInfoDTO> coins) {
		this.coins = coins;
	}
	public List<EquipmentOverviewDTO> getEquipment() {
		return equipment;
	}
	public void setEquipment(List<EquipmentOverviewDTO> equipment) {
		this.equipment = equipment;
	}
	
}
