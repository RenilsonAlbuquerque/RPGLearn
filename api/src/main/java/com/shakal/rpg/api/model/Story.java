package com.shakal.rpg.api.model;

import org.springframework.data.annotation.Id;

public class Story {
	
	@Id
	private long id;
	
	private String name;
	
	private String background;
	
	private String folderImage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getFolderImage() {
		return folderImage;
	}

	public void setFolderImage(String folderImage) {
		this.folderImage = folderImage;
	}
	
	
	
	

}
