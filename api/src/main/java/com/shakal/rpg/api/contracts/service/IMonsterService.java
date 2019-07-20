package com.shakal.rpg.api.contracts.service;


import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.MonsterInfoDTO;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

public interface IMonsterService {
	
	MonsterSheetDTO getMonsterSheetById(long id) throws ResourceNotFoundException;
	CustomPage<MonsterOverviewDTO> searchMonsterPaged(String search, PaginationFilter filter);
	CustomPage<MonsterOverviewDTO> listsMonsterPaged(PaginationFilter filter);
	MonsterInfoDTO getMonsterInfoById(long id) throws ResourceNotFoundException;
	MonsterCreateInputDTO getMonsterInfoToCreate();
}
