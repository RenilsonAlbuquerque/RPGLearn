package com.shakal.rpg.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.model.character.ClassLevel;
import com.shakal.rpg.api.model.embedded.ClassLevelId;

public interface ClassLevelDAO extends JpaRepository<ClassLevel,ClassLevelId>{

	@Query("SELECT cl FROM ClassLevel cl FETCH ALL PROPERTIES where cl.clasS.id = ?1 and cl.level.id = ?2")
	Optional<ClassLevel> retrieveFirstLevelOfClass(long classId, long levelId);
}
