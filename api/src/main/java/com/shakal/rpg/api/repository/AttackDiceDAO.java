package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.relation.AttackDice;


public interface AttackDiceDAO extends JpaRepository<AttackDice,Long> {

}
