package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.WeaponInfoDTO;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IWeaponService {
	

	CustomPage<WeaponOverviewDTO> getWeaponList(String search, PaginationFilter filter);
	WeaponInfoDTO getWeaponDetail(long id) throws ResourceNotFoundException;
}
