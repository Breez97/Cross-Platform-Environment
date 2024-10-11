package com.breez.practice_3.task_3;

import java.util.Random;

public class Patient implements Runnable {
	private static int patientCount = 0;
	private final int id;
	private final Clinic clinic;

	public Patient(Clinic clinic) {
		this.id = patientCount++;
		this.clinic = clinic;
	}

	public int getId() {
		return id;
	}

	@Override
	public void run() {
		try {
			clinic.therapistSemaphore.acquire();
			clinic.removePatientFromQueue(this);
			System.out.println("Пациент " + (id + 1) + " у терапевта");
			Thread.sleep(new Random().nextInt(1000) + 500);
			clinic.mrtSemaphore.acquire();
			clinic.therapistSemaphore.release();
			System.out.println("Пациент " + (id + 1) + " на МРТ");
			Thread.sleep(new Random().nextInt(2000) + 1000);
			clinic.mrtSemaphore.release();
			System.out.println("Пациент " + (id + 1) + " закончил обследование");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
