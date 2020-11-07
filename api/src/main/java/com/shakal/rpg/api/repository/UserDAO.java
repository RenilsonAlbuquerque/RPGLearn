package com.shakal.rpg.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.relation.UserStory;

public interface UserDAO extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);
	
}
