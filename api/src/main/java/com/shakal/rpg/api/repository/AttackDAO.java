package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Attack;

public interface AttackDAO extends JpaRepository<Attack,Long> {

}
