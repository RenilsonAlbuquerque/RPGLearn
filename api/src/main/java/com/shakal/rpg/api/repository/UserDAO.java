package com.shakal.rpg.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shakal.rpg.api.model.User;

public interface UserDAO extends JpaRepository<User,Long> {

}
