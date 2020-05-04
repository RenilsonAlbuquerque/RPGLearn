package com.shakal.rpg.api.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.model.Creature;



public interface CreatureDAO  extends JpaRepository<Creature,Long> {

	@Query("SELECT cr FROM Creature cr left join cr.token where cr.id = ?1")
	Optional<Creature> retrieveCharacterWithTokenById(long characterId);
}
