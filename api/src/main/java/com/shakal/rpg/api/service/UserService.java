package com.shakal.rpg.api.service;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.UserCreateDTO;
import com.shakal.rpg.api.dto.create.UserStoryManagementInputDTO;
import com.shakal.rpg.api.exception.DuplicatedResourceException;
import com.shakal.rpg.api.mappers.PlaceMapper;
import com.shakal.rpg.api.mappers.UserMapper;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.character.Character;
import com.shakal.rpg.api.model.embedded.UserStoryId;
import com.shakal.rpg.api.model.relation.UserStory;
import com.shakal.rpg.api.repository.UserDAO;
import com.shakal.rpg.api.repository.UserStoryDAO;
import com.shakal.rpg.api.security.AuthenticationContext;
import com.shakal.rpg.api.utils.Messages;

@Service
public class UserService implements UserDetailsService, IUserService {

	private UserDAO userDAO;
	private UserStoryDAO userStoryDao;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserDAO userDAO, BCryptPasswordEncoder bCryptPasswordEncoder, UserStoryDAO userStoryDao) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userDAO = userDAO;
		this.userStoryDao = userStoryDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		return this.userDAO.findByUsername(username)
				.orElseThrow(() -> new BadCredentialsException(Messages.USER_NOT_FOUND));
	}

	@Override
	public long getCurrentUserId() {
		return ((AuthenticationContext) SecurityContextHolder.getContext().getAuthentication()).getId();
	}

	public void setCharacterToUserInStory(long storyId, long userId, Character character) {

		UserStory userStory = new UserStory();
		userStory.setId(new UserStoryId(userId, storyId));
		userStory.setCharacter(character);
		this.userStoryDao.save(userStory);

	}

	@Override
	public UserCreateDTO insertUser(UserCreateDTO createDto) throws DuplicatedResourceException {
		boolean hasUser = this.userDAO.findByUsername(createDto.getUsername()).isPresent();
		if (hasUser) {
			throw new DuplicatedResourceException(Messages.INVALID_USERNAME);
		}
		createDto.setPassword(this.bCryptPasswordEncoder.encode(createDto.getPassword()));
		this.userDAO.save(UserMapper.createToEntity(createDto));
		return createDto;
	}

	@Override
	public UserStoryManagementInputDTO getUserManagementInput(long storyId) {
		UserStoryManagementInputDTO userManagement = new UserStoryManagementInputDTO();
		userManagement.setAllAvaliableUsers(this.userDAO.findAll()
				.stream()
        		.map(user -> UserMapper.entityToKeyValue(user))
                .collect(Collectors.toList()));
		userManagement.setUsersOfStory( this.userStoryDao.retrieveAllUsersInStory(storyId)
				.stream()
        		.map(place -> UserMapper.entityToKeyValue(place))
                .collect(Collectors.toList()));
		return userManagement;
	}

}
