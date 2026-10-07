package com.java.main;

class Logger {

	private static Logger instance;

	private Logger() {

	}

	public static synchronized Logger getInstance() {
		if (instance == null) {

			
				instance = new Logger();
			
		}
		return instance;
	}
}

public class Main {
	public static void main(String[] args) {

		System.out.println("Hello world");

		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();

		System.out.println(log1 == log2);

	}

}
