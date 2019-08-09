package com.shakal.rpg.api.control;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.dto.UserDetailDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/detail")
    public ResponseEntity<UserDetailDTO> getUserDetail() {
		UserDetailDTO user = new UserDetailDTO();
		user.setId(1);
		user.setNome("Remelsom");
		user.setToken("hadouken");
		user.setAuthenticated(true);
        return new ResponseEntity<UserDetailDTO>(user, HttpStatus.OK);
    }
}
