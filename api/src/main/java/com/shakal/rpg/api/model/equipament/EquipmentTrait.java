package com.shakal.rpg.api.model.equipament;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "tb_equipment_trait")
public class EquipmentTrait {

	@Id
	@GeneratedValue
	private Long id;
}
