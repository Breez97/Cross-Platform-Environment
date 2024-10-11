package com.breez.practice_3.task_1;

import java.util.concurrent.CopyOnWriteArrayList;

public class ClassTwo implements Runnable {

	CopyOnWriteArrayList<Integer> listOfNumbers;

	public ClassTwo(CopyOnWriteArrayList<Integer> listOfNumbers) {
		this.listOfNumbers = listOfNumbers;
	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("Текущее содержание списка "  + listOfNumbers);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
