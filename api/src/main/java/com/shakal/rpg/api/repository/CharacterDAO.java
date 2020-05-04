package com.shakal.rpg.api.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.character.Character;

public interface CharacterDAO  extends JpaRepository<Character,Long>{

	
}
