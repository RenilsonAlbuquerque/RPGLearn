package com.shakal.rpg.api.mappers;

import com.shakal.rpg.api.dto.info.CoinInfoDTO;
import com.shakal.rpg.api.dto.info.CostInfoDTO;
import com.shakal.rpg.api.model.economy.Coin;
import com.shakal.rpg.api.model.economy.Cost;

public abstract class EconomyMapper {


	public static CostInfoDTO costEntityToInfo(Cost entity) {
		CostInfoDTO result = new CostInfoDTO();
		result.setId(entity.getId());
		result.setQuantity(entity.getQuantity());
		result.setCoin(coinEntityToInfo(entity.getCoin()));
		return result;
		
	}
	public static CoinInfoDTO coinEntityToInfo(Coin coin) {
		CoinInfoDTO result = new CoinInfoDTO();
		result.setId(coin.getId());
		result.setName(coin.getName());
		result.setAbreviation(coin.getAbreviation());
		return result;
	}
	
}
