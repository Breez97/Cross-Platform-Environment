package com.breez.practice_two.shop;

public class Customer {

	private String gameToBuy;
	private float moneyInWallet;

	public Customer(String gameToBuy, float moneyInWallet) {
		this.gameToBuy = gameToBuy;
		this.moneyInWallet = moneyInWallet;
	}

	public String getGameToBuy() {
		return gameToBuy;
	}

	public float getMoneyInWallet() {
		return moneyInWallet;
	}

}
