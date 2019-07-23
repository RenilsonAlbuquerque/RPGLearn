package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.relation.CreatureResistence;


public interface CreatureResistenceDAO extends JpaRepository<CreatureResistence,Long> {

}
