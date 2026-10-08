package com.java.main.strategy;

public class CashJPaymentStrategy implements PaymentStrategy{
	private String cash;
	

	public CashJPaymentStrategy(String cash) {
		super();
		this.cash = cash;
	}


	@Override
	public void pay(double amount) {
		 System.out.println("Paid ₹" + amount + " using Cash (" + cash + ")");
	}

}
