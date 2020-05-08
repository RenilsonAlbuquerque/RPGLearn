package com.shakal.rpg.api.contracts.service;

import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;

public interface IWeaponService {
	

	CustomPage<WeaponOverviewDTO> getWeaponList(String search, PaginationFilter filter);
}
