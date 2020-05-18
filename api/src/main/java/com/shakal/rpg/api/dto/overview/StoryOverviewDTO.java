package com.shakal.rpg.api.dto.overview;

public class StoryOverviewDTO {

	private long id;
	
	private String name;
	
	private String folderImage;
	
	private int userRoleInStory;
	
	

	public StoryOverviewDTO() {
		super();
	}

	public StoryOverviewDTO(long id, String name, String folderImage) {
		super();
		this.id = id;
		this.name = name;
		this.folderImage = folderImage;
	}

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

	public String getFolderImage() {
		return folderImage;
	}

	public void setFolderImage(String folderImage) {
		this.folderImage = folderImage;
	}

	public int getUserRoleInStory() {
		return userRoleInStory;
	}

	public void setUserRoleInStory(int userRoleInStory) {
		this.userRoleInStory = userRoleInStory;
	}
	
	
}