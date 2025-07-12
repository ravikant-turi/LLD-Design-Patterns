package com.factory.ex2;

interface Burger{
	void prepare();
}
class BasicBurger implements Burger{

	@Override
	public void prepare() {
     System.out.println("prepare basic burger ........");		
	}
	
}
class StandarBurger implements Burger{

	@Override
	public void prepare() {
 
		System.out.println("prepare Standard burger ......");
	}
	
}
class PremiumBurger implements Burger{

	@Override
	public void prepare() {
      System.out.println("prepare premiumBurger .......");		
	}
	
}
class BasicWheatBurger implements Burger{

	@Override
	public void prepare() {
System.out.println("preparing BasicwheatBurger......");		
	}
	
}
class StandarWheatBurger implements Burger{

	@Override
	public void prepare() {
 
		System.out.println("prepare Standard Wheat burger ......");
	}
	
}
class PremiumWheatBurger implements Burger{

	@Override
	public void prepare() {
      System.out.println("prepare premiumWheatBurger .......");		
	}
	
}
interface BurgerFacotry{
	Burger createBurger(String Type);
}

class SinghBurger implements BurgerFacotry{

	
	@Override
	public Burger createBurger(String type) {
		if(type.equalsIgnoreCase("basic")) {
			  return new BasicBurger();
		}
		else if(type.equalsIgnoreCase("standard")) {
			return new StandarBurger();
		}
		else if (type.equalsIgnoreCase("premium")) {
			return new  PremiumBurger();
		}
		return null;
	}
	
	
}
class KingBurger implements BurgerFacotry{
	@Override
	public Burger createBurger(String type) {
		if(type.equalsIgnoreCase("basic")){
			return new BasicWheatBurger();
		}
		else if(type.equalsIgnoreCase("standard")){
			return new StandarWheatBurger();
		}
		else if (type.equalsIgnoreCase("premium")) {
			return new PremiumWheatBurger();
		}
		return null;
	}
}

public class FactoryMain {
	public static void main(String args[]) {
		
    String type1="basic";
    String type2="standard";
    String type3="premium";
    
    BurgerFacotry kingfacotry=new KingBurger();
    BurgerFacotry singhfactry=new SinghBurger();
    
    System.out.println("==========wheat burger in kingBurger===========");
    Burger burger=kingfacotry.createBurger(type1);
    burger.prepare();
    kingfacotry.createBurger(type2);
    burger.prepare();

    kingfacotry.createBurger(type3);
    burger.prepare();

    System.out.println("========== burger in singBurger===========");
    Burger burger1=singhfactry.createBurger(type1);
    burger1.prepare();
    singhfactry.createBurger(type2);
    burger1.prepare();

    singhfactry.createBurger(type3);
    burger1.prepare();

    
		
		
	}
    

}
