package com.java.main;

interface Burger {
	void prepare();
}

class BasicBurger implements Burger {

	@Override
	public void prepare() {

		System.out.println("This is BASIC burger");
	}

}

class StandardardBurger implements Burger {

	@Override
	public void prepare() {

		System.out.println("This is STANDARD Burger");
	}

}

class PremiumBurger implements Burger {

	@Override
	public void prepare() {
		System.out.println("This is PREMIUM burger");

	}

}

class BurgerFactory {

	public Burger createBurger(String type) {

		if (type.equalsIgnoreCase("standard")) {
			return new StandardardBurger();
		}
		if (type.equalsIgnoreCase("premium")) {
			return new PremiumBurger();
		}
		if (type.equalsIgnoreCase("Basic")) {
			return new BasicBurger();
		}
		return null;

	}
}

public class Main {

	public static void main(String[] args) {

		String type = "STAndard";

		BurgerFactory factory = new BurgerFactory();

		Burger basic = factory.createBurger(type);

		basic.prepare();

	}

}
