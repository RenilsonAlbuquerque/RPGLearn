package com.shakal.rpg.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.repository.UserDAO;

@SpringBootApplication
public class ApiApplication implements ApplicationRunner{

	@Autowired
	private UserDAO userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(ApiApplication.class, args);
		
	}
	 @Override
	   public void run(ApplicationArguments arg0) throws Exception {
		 if(userRepository.findAll().isEmpty()) {
				String password = bCryptPasswordEncoder.encode("123456");
				this.userRepository.save(new User("renilson",password));
				String password2 = bCryptPasswordEncoder.encode("123456");
				this.userRepository.save(new User("shakal",password2));
			}
	   }

}
