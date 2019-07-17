package com.shakal.rpg.api.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shakal.rpg.api.contracts.service.IMonsterService;
import com.shakal.rpg.api.dto.MonsterSheetDTO;
import com.shakal.rpg.api.exception.ResourceNotFoundException;
import com.shakal.rpg.api.model.Atribute;
import com.shakal.rpg.api.repository.AtributeDAO;



@CrossOrigin
@RestController
@RequestMapping("/monster")
public class MonsterController {

	@Autowired
	private IMonsterService monsterService;
	
	@Autowired
	private  AtributeDAO  atributeDao;
	
	@GetMapping("/sheet/{id}")
    public ResponseEntity<MonsterSheetDTO> getMonsterById(@PathVariable Long id) throws ResourceNotFoundException {
    	//long userId = ((User) SecurityContextHolder.getContext().getAuthentication().getDetails()).getId();
        return new ResponseEntity<MonsterSheetDTO>(monsterService.getMonsterSheetById(id), HttpStatus.OK);
    }
	
	@GetMapping("/atr")
    public List<Atribute> getMonsterById() throws ResourceNotFoundException {
		List<Atribute> all =this.atributeDao.findAll();
    	return all;
    }
}
