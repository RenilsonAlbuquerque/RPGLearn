package com.shakal.rpg.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.shakal.rpg.api.model.enums.DamageTypeEnum;


@Entity
@Table(name= "tb_damage_type")
public class DamageType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Embedded
	@Enumerated(EnumType.STRING)
	private DamageTypeEnum value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DamageTypeEnum getValue() {
		return value;
	}

	public void setValue(DamageTypeEnum value) {
		this.value = value;
	}
	
	
}
