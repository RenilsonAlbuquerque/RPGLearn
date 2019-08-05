package com.shakal.rpg.api.model.mongo;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


import com.shakal.rpg.api.model.mongo.Place;

@Document(collection = "story")
public class Story {
	
	@Id
	private String id;
	
	private String name;
	
	private String background;
	
	private String folderImage;

	
	private List<Place> places;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> collect) {
		this.places = collect;
		
	}


	
	
	
	

}
