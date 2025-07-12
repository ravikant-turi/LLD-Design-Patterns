package com.strategy.ex2;


interface TravelStrategy{
	void travel(String destination);
}
class CarTravel implements TravelStrategy{

	@Override
	public void travel(String destination) {
	System.out.println("Travel to "+ destination + "by car");
	}
	
}
class BikeTravel implements TravelStrategy{

	@Override
	public void travel(String destination) {
		// TODO Auto-generated method stub
		System.out.println("Travel to "+ destination + " By Bike");
		
	}
	
}
class BusTravel implements TravelStrategy{

	@Override
	public void travel(String destination) {
		// TODO Auto-generated method stub
		System.out.println("Travel to "+ destination + "By Bus");
	}
	
}
class TravelContext {
	TravelStrategy strategy;
	
	public void setTravelContext(TravelStrategy strategy) {
		// TODO Auto-generated constructor stub
		this.strategy=strategy;
	}
	public void goToDestination(String destination) {
		strategy.travel(destination);
	}
}
public class TravelApp {
	public static void main(String[] args) {
		
	System.out.println("========Welcome to My TravelAgency======");
	TravelContext context=new TravelContext();
	
	context.setTravelContext(new BikeTravel());
	context.goToDestination("Ranchi");
	
	
	context.setTravelContext(new CarTravel());
	context.goToDestination("Ranchi");
	
	context.setTravelContext(new BusTravel());
	context.goToDestination("Ranchi");
	}
	
	

}
