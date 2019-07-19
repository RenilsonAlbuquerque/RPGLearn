package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.shakal.rpg.api.model.Monster;


public interface MonsterDAO extends JpaRepository<Monster,Long>, JpaSpecificationExecutor<Monster> {
	

	
	
	
}
