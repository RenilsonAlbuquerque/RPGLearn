package com.shakal.rpg.api.dto.filter;

public class UserSheetFIlterDTO {
	
	private long userId;
	private long storyId;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getStoryId() {
		return storyId;
	}
	public void setStoryId(long storyId) {
		this.storyId = storyId;
	}

}
