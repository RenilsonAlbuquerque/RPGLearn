package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Dice;

public interface DiceDAO extends JpaRepository<Dice,Long> {

}
