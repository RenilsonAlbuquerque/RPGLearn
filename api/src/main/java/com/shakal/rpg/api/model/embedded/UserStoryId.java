package com.shakal.rpg.api.model.embedded;

import java.io.Serializable;

import javax.persistence.Column;

public class UserStoryId implements Serializable {


    @Column(name = "user_id")
    private Long userId;
    
	@Column(name = "story_id")
    private Long storyId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStoryId() {
		return storyId;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}
	
	
}
