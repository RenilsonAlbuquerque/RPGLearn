package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shakal.rpg.api.model.DamageType;

public interface DamageTypeDAO extends JpaRepository<DamageType,Long>{

}
