package com.shakal.rpg.api.model.character;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.shakal.rpg.api.model.creature.Proeficiency;


@Entity
@Table(name= "tb_class_starting_proeficiency_choice")
public class ClassStartingProeficiencyChoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private int choose;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "mtm_class_starting_proeficiency_choice",
            joinColumns = @JoinColumn(name = "starting_proeficiency_id", referencedColumnName = "id"),
            inverseJoinColumns =  @JoinColumn(name = "proeficiency_id", referencedColumnName = "id"))
    private List<Proeficiency> proeficiencyChoices;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Class clasS;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getChoose() {
		return choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public List<Proeficiency> getProeficiencyChoices() {
		return proeficiencyChoices;
	}

	public void setProeficiencyChoices(List<Proeficiency> proeficiencyChoices) {
		this.proeficiencyChoices = proeficiencyChoices;
	}

	public Class getClasS() {
		return clasS;
	}

	public void setClasS(Class clasS) {
		this.clasS = clasS;
	}
	
	
	

}
