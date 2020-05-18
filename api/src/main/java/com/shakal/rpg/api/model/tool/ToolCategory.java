package com.shakal.rpg.api.model.tool;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.shakal.rpg.api.model.equipament.EquipamentCategory;

@Entity
@Table(name= "tb_tool_category")
@PrimaryKeyJoinColumn(name = "id")
public class ToolCategory extends EquipamentCategory {

	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Tool.class)
	private List<Tool> tool;

	public List<Tool> getTool() {
		return tool;
	}

	public void setTool(List<Tool> tool) {
		this.tool = tool;
	}
	
	
}
