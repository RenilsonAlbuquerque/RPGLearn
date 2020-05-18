package com.shakal.rpg.api.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.contracts.entity.ICreature;
import com.shakal.rpg.api.model.relation.CreatureAtribute;
import com.shakal.rpg.api.model.relation.CreatureResistence;

@Entity
@Table(name= "tb_creature")
@Inheritance( strategy = InheritanceType.JOINED)
public abstract class Creature implements ICreature, Serializable{

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length = 500)
	private String imagePath;
	
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.REMOVE, mappedBy= "creature")
	private ImageToken token;
	
	private int speed;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@JoinColumn(name ="alignment_id")
	private Alignment alignment;

	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CreatureAtribute> atributes;
	
	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CreatureResistence> resistences;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_creature_language",
            joinColumns = @JoinColumn(name = "creature_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "language_id", referencedColumnName = "id"))
    private List<Language> languages;
	
	@OneToMany(mappedBy = "creature",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Action> actions;
	
	public Long getId() {
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

	
	public ImageToken getToken() {
		return token;
	}

	public void setToken(ImageToken token) {
		this.token = token;
	}

	public List<CreatureResistence> getResistences() {
		return resistences;
	}

	public void setResistences(List<CreatureResistence> resistences) {
		this.resistences = resistences;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAtributes(List<CreatureAtribute> atributes) {
		this.atributes = atributes;
	}
	
	

	public List<CreatureAtribute> getAtributes() {
		return atributes;
	}

	
	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	
	public List<Action> getActions() {
		return actions;
	}
	
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
	
	public Alignment getAlignment() {
		return alignment;
	}

	public void setAlignment(Alignment alignment) {
		this.alignment = alignment;
	}
	

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public CreatureAtribute getForce() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 1) {
				result = a;
			}
		}
		return result;
	}

	@Override
	public CreatureAtribute getDexterity() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 2) {
				result = a;
			}
		}
		return result;
	}

	@Override
	public CreatureAtribute getConstitution() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 3) {
				result = a;
			}
		}
		return result;
	}

	@Override
	public CreatureAtribute getInteligence() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 4) {
				result = a;
			}
		}
		return result;
	}

	@Override
	public CreatureAtribute getWisdom() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 5) {
				result = a;
			}
		}
		return result;
	}

	@Override
	public CreatureAtribute getCharisma() {
		CreatureAtribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getId() == 6) {
				result = a;
			}
		}
		return result;
	}
	
	 
}
