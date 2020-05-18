package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IClassService;
import com.shakal.rpg.api.dto.create.ClassDetailInputDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/class")
public class ClassController {
	
	@Autowired
	private IClassService classService;
	
	@GetMapping("/info/{id}")
	public ResponseEntity<ClassDetailInputDTO> getClassInfoById(@PathVariable Long id) throws ResourceNotFoundException {    	
	    return new ResponseEntity<ClassDetailInputDTO>(this.classService.getClassMetadata(id), HttpStatus.OK);
	}

}
