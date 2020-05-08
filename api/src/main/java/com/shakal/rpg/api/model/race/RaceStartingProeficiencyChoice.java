package com.shakal.rpg.api.model.race;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.equipament.EquipamentCategory;

@Entity
@Table(name= "tb_race_starting_proeficiency_choice")
public class RaceStartingProeficiencyChoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int choose;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_race_starting_proeficiency_choice",
            joinColumns = @JoinColumn(name = "starting_proeficiency_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "equipment_category_id", referencedColumnName = "id"))
    private List<EquipamentCategory> equipmentProeficiency;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Race race;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getChoose() {
		return choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public List<EquipamentCategory> getEquipmentProeficiency() {
		return equipmentProeficiency;
	}

	public void setEquipmentProeficiency(List<EquipamentCategory> equipmentProeficiency) {
		this.equipmentProeficiency = equipmentProeficiency;
	}
	
	

}
