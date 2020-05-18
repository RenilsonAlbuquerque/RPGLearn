package com.shakal.rpg.api.dto.info;

public class CostInfoDTO {
	private long id;
	private int quantity;
	private CoinInfoDTO coin;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CoinInfoDTO getCoin() {
		return coin;
	}
	public void setCoin(CoinInfoDTO coin) {
		this.coin = coin;
	}
	
	

}
