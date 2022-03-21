package com.javarush.task.task16.task1632;

public class MessageThread extends Thread implements Message {


	@Override
	public void showWarning() {
		interrupt();
	}
}
