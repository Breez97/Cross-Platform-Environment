package com.breez.practice_3.task_3;

public class App {
	public static void main(String[] args) throws InterruptedException {
		Clinic clinic = new Clinic();
		int amountOfPatients = 10;
		int interval = 1000;
		clinic.startPatientArrival(amountOfPatients, interval);
	}
}
