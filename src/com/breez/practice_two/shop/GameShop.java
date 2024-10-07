package com.breez.practice_two.shop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameShop {

	private final Map<String, BoardGame> gamesCatalog;
	private float earnings;

	public GameShop() {
		this.gamesCatalog = new HashMap<>(Map.of(
				"Переворот", new BoardGame("Переворот", 2, 6, 15, 13, 990),
				"Дюна: Война за Арракис", new BoardGame("Дюна: Война за Арракис", 1, 4, 120, 13, 14990),
				"Остров духов: Инкарнация природы", new BoardGame("Остров духов: Инкарнация природы", 1, 6, 120, 13, 4990),
				"Сумбурный квиз: Знаток слов", new BoardGame("Сумбурный квиз: Знаток слов", 2, 6, 15, 12, 190),
				"Соображарий: Супер", new BoardGame("Соображарий: Супер", 2, 4, 40, 18, 490),
				"Бункер", new BoardGame("Бункер", 4, 16, 45, 18, 2990),
				"Герои", new BoardGame("Герои", 2, 4, 60, 10, 1290),
				"Трудванг: Легенды", new BoardGame("Трудванг: Легенды", 1, 4, 120, 13,12990),
				"Каркассон", new BoardGame("Каркассон", 2, 5, 35, 7, 1990),
				"Эверделл", new BoardGame("Эверделл", 1, 4, 60, 10, 6990)
		));
		this.earnings = 0;
	}

	public List<BoardGame> getCatalog() {
		return new ArrayList<>(gamesCatalog.values());
	}

	public float getEarnings() {
		return earnings;
	}

	public BoardGame buyGame(String name, float moneyInWallet) {
		BoardGame game = gamesCatalog.get(name);
		if (game != null) {
			float gamePrice = game.getPrice();
			if (moneyInWallet >= gamePrice) {
				earnings += gamePrice;
				gamesCatalog.remove(name);
				System.out.println("\tИгра " + game.getName() + " куплена за " + gamePrice);
				return game;
			} else {
				System.out.println("\tУ покупателя недостаточно средств на счету");
				return null;
			}
		}
		System.out.println("\tТакой игры уже нет в наличии");
		return null;
	}
}
