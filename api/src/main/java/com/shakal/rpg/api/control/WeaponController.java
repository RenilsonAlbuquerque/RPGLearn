package com.shakal.rpg.api.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IWeaponService;
import com.shakal.rpg.api.dto.filter.CustomPage;
import com.shakal.rpg.api.dto.filter.PaginationFilter;
import com.shakal.rpg.api.dto.overview.WeaponOverviewDTO;

@CrossOrigin
@RestController
@RequestMapping("/weapon")
public class WeaponController {
	
	@Autowired
	private IWeaponService weaponService;
	
	
	@PostMapping(value = "/filter",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	 public ResponseEntity<CustomPage<WeaponOverviewDTO>> filter(@RequestBody PaginationFilter filter,
	    													@RequestParam(required = false) String name
	    													){
	    	
	    	 return new ResponseEntity<CustomPage<WeaponOverviewDTO>>
	    	 		(weaponService.getWeaponList(name,filter), HttpStatus.OK);
	 }

}
