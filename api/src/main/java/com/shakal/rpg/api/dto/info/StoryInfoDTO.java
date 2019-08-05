package com.shakal.rpg.api.dto.info;

import java.util.List;

public class StoryInfoDTO {

	private long id;
	private String name;
	private String background;
	private String folderImage;
	private List<PlaceInfoDTO> places;
	
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
	public List<PlaceInfoDTO> getPlaces() {
		return places;
	}
	public void setPlaces(List<PlaceInfoDTO> places) {
		this.places = places;
	}
	
	
}
