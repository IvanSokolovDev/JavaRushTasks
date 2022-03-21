package com.javarush.task.task16.task1632;

public class ExceptionThread extends Thread {
	@Override
	public void run() {
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("InterrupedException");
		}
	}
}
