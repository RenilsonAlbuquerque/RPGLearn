package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name= "tb_story")
public class Story{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 1200)
	private String background;
	
	private String folderImage;

	@OneToMany(mappedBy = "story",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = Place.class)
	private List<Place> places;
	
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

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	
	
	

}
