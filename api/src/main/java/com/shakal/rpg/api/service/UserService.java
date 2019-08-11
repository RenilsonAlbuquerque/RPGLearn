package com.shakal.rpg.api.service;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.dto.create.CreateUserDTO;
import com.shakal.rpg.api.mappers.UserMapper;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.repository.UserDAO;
import com.shakal.rpg.api.utils.Messages;




@Service
public class UserService implements UserDetailsService {



	private UserDAO userDAO;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserDAO userDAO, BCryptPasswordEncoder bCryptPasswordEncoder){
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDAO = userDAO;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return this.userDAO.findByUsername(username)
				.orElseThrow(() -> new BadCredentialsException(Messages.USER_NOT_FOUND));
	}
	

	public Boolean createUser(CreateUserDTO user){
		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		this.userDAO.save(UserMapper.createToEntity(user));
		return true;
	}
}
