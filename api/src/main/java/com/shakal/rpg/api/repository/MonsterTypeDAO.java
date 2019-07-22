package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shakal.rpg.api.model.MonsterType;

public interface MonsterTypeDAO extends JpaRepository<MonsterType,Long>{

}
