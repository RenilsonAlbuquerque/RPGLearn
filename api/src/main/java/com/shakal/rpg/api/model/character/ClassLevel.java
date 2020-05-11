package com.shakal.rpg.api.model.character;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.shakal.rpg.api.model.CreatureLevel;
import com.shakal.rpg.api.model.embedded.ClassLevelId;


@Entity
@Table(name= "mtm_class_level")
public class ClassLevel {

	
	
	@Id
	@EmbeddedId
	private ClassLevelId id;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("classId")
	private Class clasS;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	@MapsId("levelId")
	private CreatureLevel level;
	

	public ClassLevelId getId() {
		return id;
	}

	public void setId(ClassLevelId id) {
		this.id = id;
	}

	public Class getClasS() {
		return clasS;
	}

	public void setClasS(Class clasS) {
		this.clasS = clasS;
	}

	public CreatureLevel getLevel() {
		return level;
	}

	public void setLevel(CreatureLevel level) {
		this.level = level;
	}
	

	

	
	
	
	
}
