package com.breez.practice_3.task_2;

import java.util.Random;

public class Window {

	private final int number;
	private final ClientType[] allowedTypes;
	private boolean isBusy = false;

	public Window(int number, ClientType... allowedTypes) {
		this.number = number;
		this.allowedTypes = allowedTypes;
	}

	public synchronized boolean canServe(ClientType clientType) {
		if (isBusy) return false;
		for (ClientType type : allowedTypes) {
			if (type == clientType) {
				return true;
			}
		}
		return false;
	}

	public synchronized void service(Person person) throws InterruptedException {
		isBusy = true;
		try {
			Thread.sleep(new Random().nextInt(1000));
		} finally {
			isBusy = false;
		}
	}

}
