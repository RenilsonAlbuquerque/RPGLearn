package com.shakal.rpg.api.model.tool;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.Equipament;

@Entity
@Table(name="tb_tool")
@PrimaryKeyJoinColumn(name = "id")
public class Tool extends Equipament {

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = ToolCategory.class)
	@JoinColumn(name ="category_id", referencedColumnName = "id")
	private ToolCategory category;
}
