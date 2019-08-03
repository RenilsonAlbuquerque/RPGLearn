package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Action;


public interface ActionDAO extends JpaRepository<Action,Long> {

}
