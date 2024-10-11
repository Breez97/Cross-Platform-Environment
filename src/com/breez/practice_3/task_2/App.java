package com.breez.practice_3.task_2;

import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException {
		Window[] windows = {
				new Window(1, ClientType.YOUNG, ClientType.ELDERLY, ClientType.BUSINESS),
				new Window(2, ClientType.ELDERLY),
				new Window(3, ClientType.BUSINESS)
		};
		int totalClients = 10;
		Thread[] threads = new Thread[totalClients];
		for (int i = 0; i < totalClients; i++) {
			ClientType type = ClientType.values()[new Random().nextInt(3)];
			threads[i] = new Thread(new Person(type, windows));
			threads[i].start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		Person.printStatistics();
	}

}
