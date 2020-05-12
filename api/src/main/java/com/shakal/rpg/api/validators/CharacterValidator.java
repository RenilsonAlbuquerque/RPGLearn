package com.shakal.rpg.api.validators;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import com.shakal.rpg.api.dto.create.CharacterCreateDTO;
import com.shakal.rpg.api.model.Alignment;
import com.shakal.rpg.api.model.Race;
import com.shakal.rpg.api.model.character.Class;
import com.shakal.rpg.api.model.character.ClassLevel;

public class CharacterValidator {
	
	

	public static ErrorMessages ValidateDTO(CharacterCreateDTO insertDto,ErrorMessages errorMessages) {
		/*
		if(insertDto.getSecretBackground().length() >= 1200) {
			errorMessages.addError("Texto de background muito grande");
		}
		*/
		if(insertDto.getName().length() < 1 ) {
			errorMessages.addError("Nome o personagem muito curto");
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
	public static ErrorMessages ValidateRecoveryClassEntities(ErrorMessages errorMessages,
			Optional<ClassLevel> classLevel, Optional<Class> clasS) {
		if(!classLevel.isPresent()) {
			errorMessages.addError("Classe Nível Inválido");
		}
		if(!clasS.isPresent()) {
			errorMessages.addError("Classe Inválida");
		}
		return errorMessages;
	}
	public static void validateToken(String base64, ErrorMessages errors) {
		
		try {
			base64.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			errors.addError("Token inválido");
		}
	}
}
