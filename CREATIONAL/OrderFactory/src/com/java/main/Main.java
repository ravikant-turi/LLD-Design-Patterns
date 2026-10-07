package com.java.main;

interface Order{
	void prapareOrder();
}


class DeliveryOrder implements Order{

	@Override
	public void prapareOrder() {
		System.out.println("Prepare Delivery order");
	}
	
}
class PicupOrder implements Order{

	@Override
	public void prapareOrder() {
		
		System.out.println("Prepare Pickup Order");
	}
	
}

interface IOrderFactory{
	Order createOrder (String type);
}

class scheduleOrderFactory implements IOrderFactory{

	@Override
	public Order createOrder(String type) {
		
		if(type.equalsIgnoreCase("DeliveryOrder")) {
			System.out.println("Schedule DeliveryOrder Order prepared");
			return new DeliveryOrder();
		}
		if(type.equalsIgnoreCase("PicupOrder")) {
			System.out.println("Schedule PicupOrder Order prepared");
			return new PicupOrder();
		}
		return null;
		
	}
	
}
class NowOrderFactory implements IOrderFactory{

	@Override
	public Order createOrder(String type) {
		
		if(type.equalsIgnoreCase("DeliveryOrder")) {
			System.out.println("Immediate DeliveryOrder Order prepared");
			return new DeliveryOrder();
		}
		if(type.equalsIgnoreCase("PicupOrder")) {
			System.out.println("Immediate PicupOrder Order prepared");
			return new PicupOrder();
		}
		return null;
		
	}
	
}
public class Main {
	
	public static void main(String[] args) {
		
		String type="PicupOrder";
//		String type="DeliveryOrder";
		
		IOrderFactory myfactory=new  NowOrderFactory();
		Order myOrder= myfactory.createOrder(type);
		myOrder.prapareOrder();
		
		
		String type1="PicupOrder";
//		String type1="DeliveryOrder";
		
		IOrderFactory myfactory1=new  scheduleOrderFactory();
		Order myOrder1= myfactory1.createOrder(type1);
		myOrder1.prapareOrder();
		
	}

}
