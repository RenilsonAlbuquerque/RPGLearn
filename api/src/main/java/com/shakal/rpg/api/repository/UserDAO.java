package com.shakal.rpg.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.User;

public interface UserDAO extends JpaRepository<User,Long> {

	Optional<User> findByUsername(String username);
}
