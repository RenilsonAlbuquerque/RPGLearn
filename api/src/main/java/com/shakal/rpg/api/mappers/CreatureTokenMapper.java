package com.shakal.rpg.api.mappers;





import java.io.UnsupportedEncodingException;

import com.shakal.rpg.api.dto.info.CreatureTokenDTO;
import com.shakal.rpg.api.model.Creature;
import com.shakal.rpg.api.model.ImageToken;

public class CreatureTokenMapper {
	
	public static CreatureTokenDTO mapEntityToDTO(ImageToken entity) {
		CreatureTokenDTO result = new CreatureTokenDTO();
		result.setId(entity.getId());
		result.setPicture(new String(entity.getPicture()));
		return result;
	}
	public static ImageToken createToken(String base64) {
		ImageToken result = new ImageToken();
		try {
			result.setPicture(base64.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}
	public static ImageToken createToken(String base64, Creature entity) {
		ImageToken result = new ImageToken();
		try {
			result.setPicture(base64.getBytes("UTF-8"));
			result.setCreature(entity);
		} catch (UnsupportedEncodingException e) {
		}
		return result;
	}
	

}
