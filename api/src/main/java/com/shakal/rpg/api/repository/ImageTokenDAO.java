package com.shakal.rpg.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.model.ImageToken;

public interface ImageTokenDAO extends JpaRepository<ImageToken,Long> {
	
	@Query("SELECT tk FROM ImageToken tk  where tk.creature.id = ?1")
	Optional<ImageToken> retrieveCharacterTokenById(long characterId);

}
