package com.shakal.rpg.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shakal.rpg.api.model.place.PlaceMark;

@Entity
@Table(name= "tb_place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	@Column(length = 4000)
	private String background;
	
	private String map;
	
	private double xDimension;
	
	private double yDimension;
	
	private double squareDimension;
	
	private double naturalHeight;
	
	private double naturalWidth;
	
	private int squareSizeCm;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Story.class)
	@JoinColumn(name ="story_id", referencedColumnName = "id")
	private Story story;
	
	@OneToMany(mappedBy = "place",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY, targetEntity = PlaceMark.class)
	private List<PlaceMark> marks;

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

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public double getxDimension() {
		return xDimension;
	}

	public void setxDimension(double xDimension) {
		this.xDimension = xDimension;
	}

	public double getyDimension() {
		return yDimension;
	}

	public void setyDimension(double yDimension) {
		this.yDimension = yDimension;
	}

	public double getSquareDimension() {
		return squareDimension;
	}

	public void setSquareDimension(double squareDimension) {
		this.squareDimension = squareDimension;
	}

	public double getNaturalHeight() {
		return naturalHeight;
	}

	public void setNaturalHeight(double naturalHeight) {
		this.naturalHeight = naturalHeight;
	}

	public double getNaturalWidth() {
		return naturalWidth;
	}

	public void setNaturalWidth(double naturalWidth) {
		this.naturalWidth = naturalWidth;
	}

	public int getSquareSizeCm() {
		return squareSizeCm;
	}

	public void setSquareSizeCm(int squareSizeCm) {
		this.squareSizeCm = squareSizeCm;
	}

	public List<PlaceMark> getMarks() {
		return marks;
	}

	public void setMarks(List<PlaceMark> marks) {
		this.marks = marks;
	}

	
	
}
