package com.breez.practice_two.shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

	public static void main(String[] args) {
		GameShop gameShop = new GameShop();
		Random random = new Random();
		int totalGamesAmount = gameShop.getCatalog().size();

		System.out.println("-------------------------------------------");
		System.out.println("Каталог игр в начале дня: ");
		for (BoardGame game : gameShop.getCatalog()) {
			System.out.println(game);
		}
		System.out.println("-------------------------------------------");
		System.out.println("Покупки: ");

		List<Customer> customers = new ArrayList<>();
		int amountOfCustomers = random.nextInt(3, 15);
		for (int i = 0; i < amountOfCustomers; i++) {
			String customerGameName = gameShop.getCatalog().get(random.nextInt(gameShop.getCatalog().size())).getName();
			float customerRandomMoney = Math.round(random.nextFloat() * random.nextInt(100000));
			customers.add(new Customer(customerGameName, customerRandomMoney));
		}

		for (Customer customer : customers) {
			gameShop.buyGame(customer.getGameToBuy(), customer.getMoneyInWallet());
			if (gameShop.getCatalog().isEmpty()) {
				break;
			}
		}

		System.out.println("-------------------------------------------");
		System.out.println("Каталог игр под конец дня: " );
		for (BoardGame game : gameShop.getCatalog()) {
			System.out.println(game);
		}
		System.out.println("-------------------------------------------");
		System.out.println("Количество проданных игр: " + (totalGamesAmount - gameShop.getCatalog().size()));
		System.out.println("Сумма выручки: " + gameShop.getEarnings() + " руб.");
	}
}
