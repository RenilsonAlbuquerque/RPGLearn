package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Action;
import com.shakal.rpg.api.model.combatstate.CombatState;

public interface CombatStateDAO extends JpaRepository<CombatState,Long> {
	
}
