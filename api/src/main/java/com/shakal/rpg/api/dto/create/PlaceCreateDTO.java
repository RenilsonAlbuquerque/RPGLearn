package com.shakal.rpg.api.dto.create;



public class PlaceCreateDTO {
	private long storyId;
	private String name;
	private String background;
	private String map;
	private double xDimension;
	private double yDimension;
	private double squareDimension;
	private int squareSizeCm;

	
	public long getStoryId() {
		return storyId;
	}

	public void setStoryId(long storyId) {
		this.storyId = storyId;
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

	public int getSquareSizeCm() {
		return squareSizeCm;
	}

	public void setSquareSizeCm(int squareSizeCm) {
		this.squareSizeCm = squareSizeCm;
	}

	

}
