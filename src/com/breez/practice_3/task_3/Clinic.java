package com.breez.practice_3.task_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Clinic {

	public final Semaphore therapistSemaphore = new Semaphore(1);
	public final Semaphore mrtSemaphore = new Semaphore(1);
	private final Queue<Patient> queue = new LinkedList<>();
	private int maxQueueLength = 0;

	public synchronized void addPatient(Patient patient) {
		queue.add(patient);
		maxQueueLength = Math.max(maxQueueLength, queue.size());
		System.out.println("Пришел пациент " + (patient.getId() + 1) + ". Текущая длина очереди: " + queue.size());
	}

	public synchronized void removePatientFromQueue(Patient patient) {
		queue.remove(patient);
		System.out.println("Пациент " + (patient.getId() + 1) + " уходит к терапевту");
	}

	public void startPatientArrival(int totalPatients, int intervalMs) throws InterruptedException {
		Thread[] patientThreads = new Thread[totalPatients];
		for (int i = 0; i < totalPatients; i++) {
			Patient patient = new Patient(this);
			addPatient(patient);
			patientThreads[i] = new Thread(patient);
			patientThreads[i].start();
			Thread.sleep(intervalMs);
		}
		for (Thread thread : patientThreads) {
			thread.join();
		}
		System.out.println("Все пациенты были обслужены");
		System.out.println("Максимальная длина очереди: " + maxQueueLength);
	}
}
