package com.shakal.rpg.api.dto.create;


import java.util.List;


public class StoryCreateDTO {

	private String name;
	
	private String background;
	
	private String folderImage;
	
	private List<PlaceCreateDTO> places;


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


	public List<PlaceCreateDTO> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceCreateDTO> places) {
		this.places = places;
	}
	
	
}
