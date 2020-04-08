package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.character.Class;

public interface ClassDAO  extends JpaRepository<Class,Long>{

}
