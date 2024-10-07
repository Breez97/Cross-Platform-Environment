package com.breez.practice_two.shop;

public class BoardGame {

	private String name;
	private int playerMin;
	private int playerMax;
	private int gameDuration;
	private int minAge;
	private float price;

	public BoardGame(String name, int playerMin, int playerMax, int gameDuration, int minAge, float price) {
		this.name = name;
		this.playerMin = playerMin;
		this.playerMax = playerMax;
		this.gameDuration = gameDuration;
		this.minAge = minAge;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPlayerMin() {
		return playerMin;
	}

	public int getPlayerMax() {
		return playerMax;
	}

	public int getGameDuration() {
		return gameDuration;
	}

	public int getMinAge() {
		return minAge;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Название: " + name +
				"\n\tИгроков: минимум: " + playerMin + ", максимум: " + playerMax +
				"\n\tДлительность: " + gameDuration +
				"\n\tМинимальный возраст: " + minAge +
				"\n\tЦена: " + price;
	}

}
