package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.dto.filter.CombatStateDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;


@CrossOrigin
@RestController
@RequestMapping("/combat")
public class CombatController {
	

	
	private final SimpMessagingTemplate template;
	
	@Autowired
    public CombatController(SimpMessagingTemplate template) {
        this.template = template;
    }
	
	
	
}
