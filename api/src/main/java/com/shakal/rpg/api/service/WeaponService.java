package com.shakal.rpg.api.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IWeaponService;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;
import com.shakal.rpg.api.mappers.WeaponMapper;
import com.shakal.rpg.api.model.weapon.Weapon;
import com.shakal.rpg.api.repository.WeaponDAO;
import com.shakal.rpg.api.specification.WeaponSpecification;
import com.shakal.rpg.api.utils.PaginationGenerator;

@Service
public class WeaponService implements IWeaponService{

	private WeaponDAO weaponRepository;
	
	@Autowired
	public WeaponService(WeaponDAO weaponRepository) {
		this.weaponRepository = weaponRepository;
	}

	@Override
	public CustomPage<WeaponOverviewDTO> getWeaponList(String search, PaginationFilter filter) {
		Specification<Weapon> specification = WeaponSpecification.searchWeapon(search);
	    
    	Page<Weapon> page = this.weaponRepository.findAll(specification,PageRequest.of(filter.getPage() -1, 
				filter.getSize()));
    	return (CustomPage<WeaponOverviewDTO>) PaginationGenerator.convertPage(page,
    			page
        		.stream().map( weapon -> WeaponMapper.entityToOverview(weapon))
                .collect(Collectors.toList()));
	}

	

}
