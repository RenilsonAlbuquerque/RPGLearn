package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IPlaceService;
import com.shakal.rpg.api.dto.info.PlaceInfoDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/place")
public class PlaceController {
	
	@Autowired
	private IPlaceService placeService;
	
	@GetMapping("/info/{id}")
	public ResponseEntity<PlaceInfoDTO> getMonsterInfoById(@PathVariable Long id) throws ResourceNotFoundException {
	    	
	    return new ResponseEntity<PlaceInfoDTO>(this.placeService.getStoryById(id), HttpStatus.OK);
	}

}
