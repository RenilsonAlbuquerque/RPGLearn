package com.shakal.rpg.api.dto.info;

public class CharacterInfoDTO {

	private long id;
	private String imagePath;
	private String name;
	private String background;
	private int age;
	private int height;
	private int weight;
	private long alignment;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public long getAlignment() {
		return alignment;
	}
	public void setAlignment(long alignment) {
		this.alignment = alignment;
	}
	
	
	
}
