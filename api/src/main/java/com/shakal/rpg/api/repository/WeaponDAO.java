package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.shakal.rpg.api.model.Weapon;

public interface WeaponDAO extends JpaRepository<Weapon,Long>{

}
