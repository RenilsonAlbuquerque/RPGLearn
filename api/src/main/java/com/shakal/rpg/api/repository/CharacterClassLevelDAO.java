package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.character.CharacterClassLevel;


public interface CharacterClassLevelDAO extends JpaRepository<CharacterClassLevel,Long>{

}
