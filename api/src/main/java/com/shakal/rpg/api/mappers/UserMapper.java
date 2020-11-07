package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.UserCreateDTO;
import com.shakal.rpg.api.model.User;
import com.shakal.rpg.api.model.relation.UserStory;

public class UserMapper {

    public static User createToEntity(UserCreateDTO createUserDTO){
        return new User(createUserDTO.getUsername(),
        				createUserDTO.getPassword());
                
    }
    public static KeyValueDTO entityToKeyValue(User entity){
    	KeyValueDTO result = new KeyValueDTO();
    	result.setId(entity.getId());
    	result.setValue(entity.getUsername());
        return result;
                
    }
    public static KeyValueDTO entityToKeyValue(UserStory entity){
    	KeyValueDTO result = new KeyValueDTO();
    	result.setId(entity.getUser().getId());
    	result.setValue(entity.getUser().getUsername());
        return result;
                
    }
}
