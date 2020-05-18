package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class ProeficiencyChoseInputDTO {
	private int choose;
	private List<KeyValueDTO> proeficiencies;
	
	public int getChoose() {
		return choose;
	}
	public void setChoose(int choose) {
		this.choose = choose;
	}
	public List<KeyValueDTO> getProeficiencies() {
		return proeficiencies;
	}
	public void setProeficiencies(List<KeyValueDTO> proeficiencies) {
		this.proeficiencies = proeficiencies;
	}
	
	

}
