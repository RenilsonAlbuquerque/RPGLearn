package com.shakal.rpg.api.model.relation;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


import com.shakal.rpg.api.model.Story;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.embedded.UserStoryId;


@Entity
@Table(name= "mtm_user_story")
public class UserStory {

	@EmbeddedId
	private UserStoryId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("userId")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@MapsId("storyId")
	private Story story;
	
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name="character_id")
	private Character character;
	
	private boolean master;
	/*
	@Enumerated(EnumType.STRING)
	private LifeStatusEnum status;
	*/
	public UserStoryId getId() {
		return id;
	}

	public void setId(UserStoryId id) {
		this.id = id;
	}


	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public boolean isMaster() {
		return master;
	}

	public void setMaster(boolean master) {
		this.master = master;
	}

	
	
}
