package com.shakal.rpg.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IWeaponService;
import com.shakal.rpg.api.repository.WeaponDAO;

@Service
public class WeaponService implements IWeaponService{

	private WeaponDAO weaponRepository;
	
	@Autowired
	public WeaponService(WeaponDAO weaponRepository) {
		this.weaponRepository = weaponRepository;
	}
}
