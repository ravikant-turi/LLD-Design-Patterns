package com.factory.ex1;
interface Burger{
	void prepare();
}
class BasicBurger implements Burger{

	@Override
	public void prepare() {
 System.out.println("preraring basic burger..........");
	}
	
}
class StandardBurger implements Burger {

	@Override
	public void prepare() {
          System.out.println("preparing standard burger ............");		
	}
	
}
class PremiumBurger implements Burger{

	@Override
	public void prepare() {
 System.out.println("preparing premium burger ............");		
	}
	
}
class BurgerFactory{
	public Burger createBurger(String type) {
		if(type.equals("basic")) {
			return new BasicBurger();
		}
		else if(type.equals("standard")){
			return new StandardBurger();
		}
		else if(type.equals("premium")) {
			return new PremiumBurger();
		}
		return null;
	}
}
public class SimpleFactory {
   public static void main(String[] args) {
	   
//	   String type="basic";
//	   String type="standard";
	   String type="premium";    

	   System.out.println("===========simple factory desin patterns==========");
	BurgerFactory factory=new BurgerFactory();
	Burger burger=factory.createBurger(type);
	
	if(burger!=null) {
		burger.prepare();
	}
}
}
