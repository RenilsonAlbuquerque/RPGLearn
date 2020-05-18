package com.shakal.rpg.api.validators;



import com.shakal.rpg.api.dto.create.StoryCreateDTO;

public abstract class StoryValidator {
	
	public static ErrorMessages ValidateDTO(StoryCreateDTO insertDto,ErrorMessages errorMessages) {
		if(insertDto.getBackground().length() >= 1200) {
			errorMessages.addError("Texto de background muito grande");
		}
		if(insertDto.getName().length() < 5 ) {
			errorMessages.addError("Nome da aventura muito curto");
		}
		if(insertDto.getName().length() > 50) {
			errorMessages.addError("Nome da aventura muito longo");
		}
		return errorMessages;
	}
	

}
