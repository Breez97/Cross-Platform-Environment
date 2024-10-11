package com.breez.practice_3.task_1;

import java.util.concurrent.CopyOnWriteArrayList;

public class App {

	public static void main(String[] args) {
		CopyOnWriteArrayList<Integer> listOfNumbers = new CopyOnWriteArrayList<>(new Integer[]{1, 2, 3, 4});

		Runnable classOne = new ClassOne(listOfNumbers);
		Runnable classTwo = new ClassTwo(listOfNumbers);

		Thread threadClassOne = new Thread(classOne);
		Thread threadClassTwo = new Thread(classTwo);

		threadClassOne.start();
		threadClassTwo.start();
	}

}
