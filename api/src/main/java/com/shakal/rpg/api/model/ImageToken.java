package com.shakal.rpg.api.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name= "tb_image_token")
public class ImageToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	@Basic(fetch = FetchType.LAZY)
	@Lob
	private byte[] picture;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="creature_id",referencedColumnName = "id")
	private Creature creature;
	
	public ImageToken() {
		
	}
	public ImageToken(byte[] picture) {
		this.picture = picture;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public Creature getCreature() {
		return creature;
	}
	public void setCreature(Creature creature) {
		this.creature = creature;
	}

	
	
	
}
