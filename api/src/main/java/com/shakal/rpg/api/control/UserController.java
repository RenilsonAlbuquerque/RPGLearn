package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IUserService;
import com.shakal.rpg.api.dto.create.UserCreateDTO;
import com.shakal.rpg.api.dto.create.UserStoryManagementInputDTO;
import com.shakal.rpg.api.exception.DuplicatedResourceException;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserCreateDTO> createStory(@RequestBody UserCreateDTO createDto) throws DuplicatedResourceException {
		return new ResponseEntity<UserCreateDTO>(this.userService.insertUser(createDto), HttpStatus.OK);
    }
	@GetMapping(value = "/manage-story/metadata/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<UserStoryManagementInputDTO> listAllUsersExceptRequested(@PathVariable Long id) throws DuplicatedResourceException {
		return new ResponseEntity<UserStoryManagementInputDTO>(this.userService.getUserManagementInput(id), HttpStatus.OK);
    }
}
