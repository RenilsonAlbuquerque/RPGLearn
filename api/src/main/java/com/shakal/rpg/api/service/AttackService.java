package com.shakal.rpg.api.service;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.ActionCreateDTO;
import com.shakal.rpg.api.dto.create.DamageDiceDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.mappers.DamageMapper;
import com.shakal.rpg.api.model.Action;
import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.embedded.CreatureResistenceId;
import com.shakal.rpg.api.model.enums.ResistenceTypeEnum;
import com.shakal.rpg.api.model.relation.AttackDice;
import com.shakal.rpg.api.model.relation.CreatureResistence;
import com.shakal.rpg.api.repository.ActionDAO;
import com.shakal.rpg.api.repository.AttackDAO;
import com.shakal.rpg.api.repository.AttackDiceDAO;
import com.shakal.rpg.api.repository.DamageTypeDAO;
import com.shakal.rpg.api.repository.DiceDAO;

@Service
public class AttackService {

	private ActionDAO actionDAO;
	private AttackDAO attackDAO;
	private AttackDiceDAO attackDiceDAO;
	private DiceDAO diceDao;
	private DamageTypeDAO damageTypeDao;
	
	public AttackService(AttackDiceDAO attackDiceDAO,DiceDAO diceDao, DamageTypeDAO damageTypeDao,
			ActionDAO actionDAO, AttackDAO attackDao) {
		this.attackDiceDAO = attackDiceDAO;
		this.diceDao = diceDao;
		this.damageTypeDao = damageTypeDao;
		this.actionDAO =  actionDAO;
		this.attackDAO = attackDao;
	}
	public List<Action> mountAttack(MonsterCreateDTO inputDto, Monster monster){
		List<Action> result = new ArrayList<Action>();
		
		for(ActionCreateDTO action: inputDto.getActions()) {
			Action actionEntity = null; 
			if(action.getDamages().isEmpty()) {
				actionEntity = new Action();
				actionEntity.setName(action.getName());
				actionEntity.setDescription(action.getDescription());
				actionEntity.setCreature(monster);
				this.actionDAO.save(actionEntity);
				
			}else {
				actionEntity = new Attack();
				actionEntity.setName(action.getName());
				actionEntity.setDescription(action.getDescription());
				
				Attack attack = this.attackDAO.save((Attack)actionEntity);
				
				for (DamageDiceDTO damage : action.getDamages()) {
					AttackDice attackDice = new AttackDice();
					attackDice.setAttack(attack);
					attackDice.setDice(this.diceDao.getOne(damage.getDice()));
					attackDice.setDamageType(this.damageTypeDao.getOne(damage.getDamageType()));
					attackDice.setQuantity(damage.getQuantity());
					this.attackDiceDAO.save(attackDice);
				}

			}
			result.add(actionEntity);
		}
		return result;
		
		
	}
	
}
