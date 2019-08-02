package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.commons.KeyValueDTO;
import com.shakal.rpg.api.model.Dice;

public class DiceMapper {

	public static KeyValueDTO diceEntityToDTO(Dice entity) {
		KeyValueDTO result = new KeyValueDTO();
		result.setId(entity.getId());
		result.setValue(entity.getValue().toString());
		return result;
	}
}
