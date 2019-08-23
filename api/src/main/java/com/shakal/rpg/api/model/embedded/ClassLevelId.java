package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ClassLevelId implements Serializable{

	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "class_id")
    private Long classId;
	
	@Column(name = "level_id")
    private Long levelId;
	
	

	

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
	
	
}
