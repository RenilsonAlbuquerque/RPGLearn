package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shakal.rpg.api.model.CreatureLevel;

public interface MonsterChallengeLevelDAO extends JpaRepository<CreatureLevel,Long> {

}
