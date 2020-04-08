package com.shakal.rpg.api.validators;

import java.util.Optional;

import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.Race;

public class CharacterValidator {

	public static ErrorMessages ValidateDTO(CharacterCreateDTO insertDto,ErrorMessages errorMessages) {
		/*
		if(insertDto.getSecretBackground().length() >= 1200) {
			errorMessages.addError("Texto de background muito grande");
		}
		*/
		if(insertDto.getName().length() < 5 ) {
			errorMessages.addError("Nome da aventura muito curto");
		}
		if(insertDto.getName().length() > 50) {
			errorMessages.addError("Nome da aventura muito longo");
		}
		return errorMessages;
	}
	public static ErrorMessages ValidateRecoveryEntities(ErrorMessages errorMessages,
			Optional<Alignment> alignment, Optional<Race> race) {
		if(!alignment.isPresent()) {
			errorMessages.addError("Alinhamento Inválido");
		}
		if(!race.isPresent()) {
			errorMessages.addError("Raça inválida");
		}
		return errorMessages;
	}
}
