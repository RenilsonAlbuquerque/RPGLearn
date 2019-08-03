package com.shakal.rpg.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.embedded.CreatureResistenceId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.model.relation.CreatureResistence;
import com.shakal.rpg.api.repository.AttackDiceDAO;

@Service
public class AttackService {

	
	private AttackDiceDAO attackDiceDAO;
	
	public AttackService(AttackDiceDAO attackDiceDAO) {
		this.attackDiceDAO = attackDiceDAO;
	}
	
}
