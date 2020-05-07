package com.shakal.rpg.api.model.equipament;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Table(name= "tb_equipament_category")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class EquipamentCategory {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	

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


	
	
	

}
