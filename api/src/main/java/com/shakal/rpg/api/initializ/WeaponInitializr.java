package com.shakal.rpg.api.initializ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.model.enums.WeaponClassificationEnum;
import com.shakal.rpg.api.model.weapon.Weapon;
import com.shakal.rpg.api.repository.WeaponDAO;

@Service
public class WeaponInitializr {
	
	@Autowired
	private WeaponDAO weaponDAO;
	
	public void initializeWeapons() {
		
		
		
		//Weapon adaga = this.weaponDAO.save(new Weapon("Adaga", WeaponClassificationEnum.SIMPLE, 0.5, 2));
		
		
	}
	
	


}
