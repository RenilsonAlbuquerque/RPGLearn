package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shakal.rpg.api.model.creature.Proeficiency;

public interface ProeficiencyDAO extends JpaRepository<Proeficiency,Long> {
	

}
