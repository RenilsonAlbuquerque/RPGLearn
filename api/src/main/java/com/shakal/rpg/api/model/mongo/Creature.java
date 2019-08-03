package com.shakal.rpg.api.model.mongo;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shakal.rpg.api.contracts.entity.ICreature;


@Document(collection = "creature")
public abstract class Creature implements ICreature{

	@Id
	private String id;
	
	
	private String imagePath;
	
	private int speed;
	
	@DBRef
	private Alignment alignment;

	/*
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
	*/


	
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	/*
	@Override
	public Atribute getForce() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.FORCE) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getDexterity() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.DEXTERITY) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getConstitution() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.CONSTITUTION) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getInteligence() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.INTELIGENCE) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getWisdom() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.WISDOM) {
				result = a.getAtribute();
			}
		}
		return result;
	}

	@Override
	public Atribute getCharisma() {
		Atribute result = null;
		for(CreatureAtribute a: this.atributes) {
			if(a.getAtribute().getValue() == AtributeEnum.CHARISMA) {
				result = a.getAtribute();
			}
		}
		return result;
	}
	
	 */
}
