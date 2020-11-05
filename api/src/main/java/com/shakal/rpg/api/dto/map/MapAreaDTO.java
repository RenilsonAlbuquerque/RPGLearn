package com.shakal.rpg.api.dto.map;

public class MapAreaDTO {
	
	private String image;
	private double xDimension;
	private double yDimension;
	private double squareSize;
	private int squareSizeCm;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public double getSquareSize() {
		return squareSize;
	}
	public void setSquareSize(double squareSize) {
		this.squareSize = squareSize;
	}
	public int getSquareSizeCm() {
		return squareSizeCm;
	}
	public void setSquareSizeCm(int squareSizeCm) {
		this.squareSizeCm = squareSizeCm;
	}
	
	

}
