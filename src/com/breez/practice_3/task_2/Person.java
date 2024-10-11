package com.breez.practice_3.task_2;

import java.util.Random;

public class Person implements Runnable {

	private final ClientType type;
	private final Window[] windows;
	private static int totalClients = 0;
	private static final int[] totalClientsByType = new int[3];
	private static final int[] angryClients = new int[3];

	public Person(ClientType type, Window[] windows) {
		this.type = type;
		this.windows = windows;
		synchronized (this) {
			totalClients++;
			totalClientsByType[type.ordinal()]++;
		}
	}

	@Override
	public void run() {
		Random random = new Random();
		int windowIndex = random.nextInt(windows.length);
		Window window = windows[windowIndex];
		if (window.canServe(type)) {
			try {
				window.service(this);
				System.out.println(type + " клиент обслужен в окне " + (windowIndex + 1));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(type + " клиент ушел из окна " + (windowIndex + 1));
			angryClients[type.ordinal()]++;
		}
	}

	public static synchronized void printStatistics() {
		System.out.println("\nВсего клиентов: " + totalClients);
		for (ClientType type : ClientType.values()) {
			int angry = angryClients[type.ordinal()];
			int total = totalClientsByType[type.ordinal()];
			double percentage = total > 0 ? (double) angry / total * 100 : 0;
			System.out.println(type + ": всего " + total + ", разгневанных " + angry + "(" + percentage + "%)");
		}
	}

}
