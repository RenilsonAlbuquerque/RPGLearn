package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.dto.create.UserCreateDTO;
import com.shakal.rpg.api.model.User;

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
}
