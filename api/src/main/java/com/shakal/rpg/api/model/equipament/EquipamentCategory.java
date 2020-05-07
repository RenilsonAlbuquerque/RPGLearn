package com.shakal.rpg.api.model.equipament;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name= "tb_equipament_category")
public class EquipamentCategory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "equipmentCategory",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = Equipament.class)
	private List<Equipament> equipaments;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Equipament> getEquipaments() {
		return equipaments;
	}

	public void setEquipaments(List<Equipament> equipaments) {
		this.equipaments = equipaments;
	}
	
	
	

}
