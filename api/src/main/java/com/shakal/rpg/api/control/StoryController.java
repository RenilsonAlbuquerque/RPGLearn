package com.shakal.rpg.api.control;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.shakal.rpg.api.contracts.service.IStoryService;
import com.shakal.rpg.api.dto.create.StoryCreateDTO;
import com.shakal.rpg.api.dto.create.StoryCreateInputDTO;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.info.StoryInfoDTO;
import com.shakal.rpg.api.dto.overview.StoryOverviewDTO;
import com.shakal.rpg.api.exception.BusinessException;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.security.AuthenticationContext;

@CrossOrigin
@RestController
@RequestMapping("/story")
public class StoryController {
	
	@Autowired
	private IStoryService storyrService;

	
	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StoryCreateDTO> createStory(@RequestBody StoryCreateDTO createDto) throws ResourceNotFoundException, BusinessException{
		return new ResponseEntity<StoryCreateDTO>(this.storyrService.insertStory(createDto), HttpStatus.OK);
    }
	
	@PostMapping(value="/player/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CustomPage<StoryOverviewDTO>> listStoriesOfPlayer(@RequestBody PaginationFilter filter){
	
		long userId = ((AuthenticationContext) SecurityContextHolder.getContext().getAuthentication()).getId();
        return new ResponseEntity<CustomPage<StoryOverviewDTO>>(this.storyrService.listsStoriesByUserIdPaged(filter, userId), HttpStatus.OK);
    }
	 @PostMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ResponseEntity<CustomPage<StoryOverviewDTO>> filter(@RequestBody PaginationFilter filter,
	    													@RequestParam(required = false) String name
	    													){
		 long userId = ((AuthenticationContext) SecurityContextHolder.getContext().getAuthentication()).getId();
		 return new ResponseEntity<CustomPage<StoryOverviewDTO>>
	    	 		(this.storyrService.searchUserStoriesPaged(userId,name,filter), HttpStatus.OK);
	 }
	@PostMapping(value="/list",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<CustomPage<StoryOverviewDTO>> listAllStories(@RequestBody PaginationFilter filter){
	
        return new ResponseEntity<CustomPage<StoryOverviewDTO>>(this.storyrService.listsStoriesPaged(filter), HttpStatus.OK);
    }
	 @GetMapping("/info/{id}")
	 public ResponseEntity<StoryInfoDTO> getMonsterInfoById(@PathVariable Long id) throws ResourceNotFoundException {
	    	
	     return new ResponseEntity<StoryInfoDTO>(this.storyrService.getStoryById(id), HttpStatus.OK);
	 }
	 @GetMapping("/input")
	 public ResponseEntity<StoryCreateInputDTO> getStoryValuesToCreate() {
	     return new ResponseEntity<StoryCreateInputDTO>(this.storyrService.getStoryInfoToCreate(), HttpStatus.OK);
	 }

}
