package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Alignment;


public interface AlignmentDAO extends JpaRepository<Alignment,Long> {

}
