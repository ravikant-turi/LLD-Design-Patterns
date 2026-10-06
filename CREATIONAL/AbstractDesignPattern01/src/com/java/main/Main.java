package com.java.main;

// --------------------PRODUCT A ----------------------
interface Burger {
	void prepare();
}

class BasicBurger implements Burger {

	@Override
	public void prepare() {
		System.out.println("BASIC BURGAR");
	}

}

class StandardBurger implements Burger {

	@Override
	public void prepare() {
		System.out.println("STANDARD BURGAR");
	}

}

class PremiumBurger implements Burger {

	@Override
	public void prepare() {
		System.out.println("PREMIUM BURGAR");
	}

}

class BasicBurgerWheate implements Burger {

	@Override
	public void prepare() {
		System.out.println("BASICWheate BURGAR");
	}

}

class StandardBurgerWheate implements Burger {

	@Override
	public void prepare() {
		System.out.println("STANDARDWheate BURGAR");
	}

}

class PremiumBurgerWheate implements Burger {

	@Override
	public void prepare() {
		System.out.println("PREMIUMWheate BURGAR");
	}

}

// ----------------------------PRODUCT B -----------------------------
interface GarlicBread {
	void prepare();
}

class BasicGarlicBread implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("BASIC Garlic Bread");
	}

}

class StandardGarlicBread implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("STANDARD Garlic Bread");
	}

}

class PremiumGarlicBread implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("PREMIUM Garlic Bread");
	}

}

class BasicGarlicBreadWheate implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("BASICWheate  Garlic Bread");
	}

}

class StandardGarlicBreadWheate implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("STANDARDWheate  Garlic Bread");
	}

}

class PremiumGarlicBreadWheate implements GarlicBread {

	@Override
	public void prepare() {
		System.out.println("PREMIUMWheate  Garlic Bread");
	}

}

// ---------------------------------FACTORY -------------------------------
interface MealFactory {
	GarlicBread createGarlicBread(String type);

	Burger createBurger(String type);
}

// ---------------------------------FACTORY 1--------------------------------------

class KingFactory implements MealFactory {

	@Override
	public GarlicBread createGarlicBread(String type) {
		if (type.equalsIgnoreCase("basic")) {
			return new BasicGarlicBread();
		} else if (type.equalsIgnoreCase("standard")) {
			return new StandardGarlicBread();
		} else if (type.equalsIgnoreCase("premium")) {
			return new PremiumGarlicBread();
		}
		return null;
	}

	@Override
	public Burger createBurger(String type) {
		if (type.equalsIgnoreCase("basic")) {
			return new BasicBurger();
		} else if (type.equalsIgnoreCase("standard")) {
			return new StandardBurger();
		} else if (type.equalsIgnoreCase("premium")) {
			return new PremiumBurger();
		}
		return null;
	}

}
//--------------------------- FACTORY 2 WHEATE ------------------------------------

class SingFactory implements MealFactory {

	@Override
	public GarlicBread createGarlicBread(String type) {
		if (type.equalsIgnoreCase("basic")) {
			return new BasicGarlicBreadWheate();
		} else if (type.equalsIgnoreCase("standard")) {
			return new StandardGarlicBreadWheate();
		} else if (type.equalsIgnoreCase("premium")) {
			return new PremiumGarlicBreadWheate();
		}
		return null;
	}

	@Override
	public Burger createBurger(String type) {
		if (type.equalsIgnoreCase("basic")) {
			return new BasicBurgerWheate();
		} else if (type.equalsIgnoreCase("standard")) {
			return new StandardBurgerWheate();
		} else if (type.equalsIgnoreCase("premium")) {
			return new PremiumBurgerWheate();
		}
		return null;
	}

}

public class Main {
	
	public static void main(String args[]) {

	String type = "Premium";
	
//	MealFactory mealFactory = new KingFactory();
	
	MealFactory mealFactory = new SingFactory();
	
	Burger burger=mealFactory.createBurger(type);
	burger.prepare();
	
	GarlicBread garlic=mealFactory.createGarlicBread(type);
	
	garlic.prepare();
	
    
	}
}
