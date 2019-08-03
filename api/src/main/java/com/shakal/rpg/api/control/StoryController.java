package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.create.MonsterCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.overview.MonsterOverviewDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;

@CrossOrigin
@RestController
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	private IStoryService storyrService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StoryCreateDTO> createStory(@RequestBody StoryCreateDTO createDto) throws ResourceNotFoundException{
		return new ResponseEntity<StoryCreateDTO>(this.storyrService.insertStory(createDto), HttpStatus.OK);
    }
	
	@PostMapping(value="/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CustomPage<StoryOverviewDTO>> listAllOverview(@RequestBody PaginationFilter filter){
        return new ResponseEntity<CustomPage<StoryOverviewDTO>>(this.storyrService.listsStoriesPaged(filter), HttpStatus.OK);
    }

}