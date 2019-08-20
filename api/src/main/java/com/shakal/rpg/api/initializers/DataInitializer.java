package com.shakal.rpg.api.initializers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.repository.UserDAO;

@Component
public class DataInitializer {/*implements ApplicationRunner {

	private UserDAO userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
    public DataInitializer(UserDAO userRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;

    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(userRepository.findAll().isEmpty()) {
			String password = bCryptPasswordEncoder.encode("123456");
			this.userRepository.save(new User("renilson",password));
		}
		
	}
	*/
}
