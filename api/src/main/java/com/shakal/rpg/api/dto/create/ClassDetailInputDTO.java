package com.shakal.rpg.api.dto.create;

import java.util.List;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;

public class ClassDetailInputDTO {
	
	private String description;
	private String lifeDice;
	private List<KeyValueDTO> savingThrows;
	private ProeficiencyChoseInputDTO proeficiencyChoose;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLifeDice() {
		return lifeDice;
	}
	public void setLifeDice(String lifeDice) {
		this.lifeDice = lifeDice;
	}
	public List<KeyValueDTO> getSavingThrows() {
		return savingThrows;
	}
	public void setSavingThrows(List<KeyValueDTO> savingThrows) {
		this.savingThrows = savingThrows;
	}
	public ProeficiencyChoseInputDTO getProeficiencyChoose() {
		return proeficiencyChoose;
	}
	public void setProeficiencyChoose(ProeficiencyChoseInputDTO proeficiencyChoose) {
		this.proeficiencyChoose = proeficiencyChoose;
	}
	
	

}
