package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.creature.CreatureSize;


public interface MonsterSizeDAO extends JpaRepository<CreatureSize,Long> {

}
