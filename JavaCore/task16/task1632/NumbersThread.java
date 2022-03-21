package com.javarush.task.task16.task1632;

import java.util.Scanner;

public class NumbersThread extends Thread {
	@Override
	public void run() {
		int sum = 0;
		String elem;

		while (!(elem = new Scanner(System.in).next()).equals("N")) {
			try {
				sum += Integer.parseInt(elem);
			} catch (Exception e) {
				System.out.println("Введено не число");
				e.printStackTrace();
			}
		}

		System.out.println(sum);
	}
}
