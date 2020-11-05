package com.shakal.rpg.api.dto.info;



public class PlaceInfoDTO {
	
	private long id;
	
	private String name;
	
	private String background;
	
	private String map;
	
	private double xDimension;
	
	private double yDimension;
	
	private double squareDimension;
	
	private double naturalHeight;
	
	private double naturalWidth;

	private int squareSizeCm;
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
	
	

}
