package com.shakal.rpg.api.service;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.shakal.rpg.api.dto.create.ActionCreateDTO;
import com.shakal.rpg.api.dto.create.DamageDiceDTO;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.model.Action;
import com.shakal.rpg.api.model.Attack;
import com.shakal.rpg.api.model.Dice;
import com.shakal.rpg.api.model.Monster;
import com.shakal.rpg.api.model.embedded.AttackDiceId;
import com.shakal.rpg.api.model.relation.AttackDice;
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
	
	@Autowired
	public AttackService(AttackDiceDAO attackDiceDAO,DiceDAO diceDao, DamageTypeDAO damageTypeDao,
			ActionDAO actionDAO, AttackDAO attackDao) {
		this.attackDiceDAO = attackDiceDAO;
		this.diceDao = diceDao;
		this.damageTypeDao = damageTypeDao;
		this.actionDAO =  actionDAO;
		this.attackDAO = attackDao;
	}
	@Transactional
	public List<Action> mountActions(List<ActionCreateDTO> actions, Monster monster, boolean legendary){
		List<Action> result = new ArrayList<Action>();
		
		for(ActionCreateDTO action: actions) {
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
				actionEntity.setCreature(monster);
				actionEntity.setLegendary(legendary);
				/*
				if(legendary) {
					actionEntity.setMonster(monster);
				}
				*/
				Attack attack = this.attackDAO.save((Attack)actionEntity);
				
				for (DamageDiceDTO damage : action.getDamages()) {
					Dice dice = this.diceDao.getOne(damage.getDice());
					AttackDice attackDice = new AttackDice();
					attackDice.setId(new AttackDiceId(attack.getId(), dice.getId()));
					attackDice.setAttack(attack);
					attackDice.setDice(dice);
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
