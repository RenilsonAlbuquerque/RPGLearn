package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.Place;

public interface PlaceDAO extends JpaRepository<Place,Long>{

}
