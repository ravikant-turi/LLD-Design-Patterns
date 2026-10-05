package com.java.mains;

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

class BasicBurgerWheate implements Burger {

	@Override
	public void prepare() {

		System.out.println("This is BASIC Wheate burger");
	}

}

class StandardardBurgerWheate implements Burger {

	@Override
	public void prepare() {

		System.out.println("This is STANDARD   Wheate Burger");
	}

}

class PremiumBurgerWheate implements Burger {

	@Override
	public void prepare() {
		System.out.println("This is PREMIUM Wheate burger");

	}

}

interface BurgerFactory {
	Burger createBurger(String type);
}

class kingBurgerFactory implements BurgerFactory {

	@Override
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

class singBurgerFactory implements BurgerFactory {

	@Override
	public Burger createBurger(String type) {

		if (type.equalsIgnoreCase("standard")) {
			return new StandardardBurgerWheate();
		}
		if (type.equalsIgnoreCase("premium")) {
			return new PremiumBurgerWheate();
		}
		if (type.equalsIgnoreCase("Basic")) {
			return new BasicBurgerWheate();
		}
		return null;

	}

}

public class Mains {
	public static void main(String[] args) {

		String type = "basic" + "";

		BurgerFactory myFactory = new singBurgerFactory();

		Burger burger = myFactory.createBurger(type);

		burger.prepare();
	}
}
