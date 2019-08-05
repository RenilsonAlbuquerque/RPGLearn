package com.shakal.rpg.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.embedded.CreatureResistenceId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.model.relation.CreatureResistence;
import com.shakal.rpg.api.repository.CreatureResistenceDAO;
import com.shakal.rpg.api.repository.DamageTypeDAO;

@Service
public class CreatureResistenceService {
	
	
	private CreatureResistenceDAO creatureResistenceDao;
	private DamageTypeDAO damageTypeDao;
	
	@Autowired
	public CreatureResistenceService(CreatureResistenceDAO creatureResistenceDao,
			DamageTypeDAO damageTypeDao) {
		this.creatureResistenceDao = creatureResistenceDao;
		this.damageTypeDao = damageTypeDao;
	}

	public List<CreatureResistence> mountResistence(MonsterCreateDTO inputDto, Monster monster){
		List<CreatureResistence> result = new ArrayList<CreatureResistence>();
		for(KeyValueDTO resistence: inputDto.getDamageResistence()) {
			CreatureResistence entity = new CreatureResistence();
			entity.setId(new CreatureResistenceId(monster.getId(),resistence.getId()));
			entity.setCreature(monster);
			entity.setDamageType(this.damageTypeDao.getOne(resistence.getId()));
			entity.setType(ResistenceTypeEnum.RESISTENCE);
			this.creatureResistenceDao.save(entity);
			result.add(entity);
		}
		for(KeyValueDTO imunity: inputDto.getDamageImunity()) {
			CreatureResistence entity = new CreatureResistence();
			entity.setId(new CreatureResistenceId(monster.getId(),imunity.getId()));
			entity.setCreature(monster);
			entity.setDamageType(this.damageTypeDao.getOne(imunity.getId()));
			entity.setType(ResistenceTypeEnum.IMUNITY);
			this.creatureResistenceDao.save(entity);
			result.add(entity);
		}
		return result;
		
	}
}
