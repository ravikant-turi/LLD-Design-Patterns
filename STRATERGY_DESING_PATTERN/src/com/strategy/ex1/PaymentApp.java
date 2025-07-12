package com.strategy.ex1;

import java.util.Date;
import java.util.UUID;

class PayInformation{
	private double amount;
	private String currency;
	private Date paymentDate;
	public PayInformation(double amount, String currency) {
		super();
		this.amount = amount;
		this.currency = currency;
		this.paymentDate =new Date();
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	
}

class PaymentStatus{
	private String transactionId;
	private boolean success;
	private String message;
	public PaymentStatus( boolean success, String message) {
		super();
		this.transactionId =UUID.randomUUID().toString();
		this.success = success;
		this.message = message;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void printReceipt() {
        System.out.println("Transaction ID: " + transactionId);
        System.out.println("Status: " + (success ? "SUCCESS" : "FAILURE"));
        System.out.println("Message: " + message);
    }
}
//1. Strategy Interface
 interface PaymentStratey{
	 PaymentStatus  pay(PayInformation payInformation);
 }
 
 //2 CreditCardPayment
 
 class CreditCardPayment implements PaymentStratey{
     private String cardNumber;
     
     public CreditCardPayment(String CardNumber) {
         this.cardNumber=CardNumber;
     }
	@Override
	public PaymentStatus pay(PayInformation payInformation) {
	  System.out.println("Processing Credit Card : " + cardNumber);
	  System.out.println("CARD NUMBER VARIFIED");
	  return new PaymentStatus(true, "paid " + payInformation.getAmount() + "by credit card");
	}
	 
 }
 //3 GooglePay 
 
 class GooglePay implements PaymentStratey{
	 private String mobileNumber;
	 
	 public GooglePay(String mobileNumber) {

	 this.mobileNumber=mobileNumber;
	 }

	@Override
	public PaymentStatus pay(PayInformation payInformation) {
		
		System.out.println("Payment is in processing");
		System.out.println("MOBILE NUMBER VARIFIEND");
		return new PaymentStatus(true, "paid "+ payInformation.getAmount() + "by GooglePay");
	}
	 
 }
 
 //4 UPI PAYMENTS
 
 class UPIPayment implements PaymentStratey{
    private String upiId;
    
    public UPIPayment(String upiId) {
            this.upiId=upiId;
    }
    
	@Override
	public PaymentStatus pay(PayInformation payInformation) {
		System.out.println("UPI is in Procession");
	System.out.println("UpiId is Varifiend");
		return new PaymentStatus(true, "paid "+payInformation.getAmount() + "by UPI");
	}
	 
 }
 //5 CONTEXT CLASS
 
 class PaymentContext{
	 private PaymentStratey paymentStratey;
	 
	 public void setPaymentContext(PaymentStratey paymentStratey) {
          this.paymentStratey=paymentStratey;
	 }
	 
	 public void processPayment(PayInformation payInfomaInformation) {
		 PaymentStatus status=paymentStratey.pay(payInfomaInformation);
		 status.printReceipt();
		 
		 
	 }
 }
 
//6. Client Code
public class PaymentApp {
 public static void main(String[] args) {
	 
	 PaymentContext context=new PaymentContext();
	 
	 System.out.println("--------Credit card Payment---------\n");
	 context.setPaymentContext(new CreditCardPayment("2222-3333-4444"));
	 context.processPayment(new PayInformation(20000, "INR"));
	 
	 System.out.println("\n\n------------Google Pay Payment --------------\n");
	 context.setPaymentContext(new GooglePay("9122222222"));
	 context.processPayment(new PayInformation(3000,"INR"));
	 
	 System.out.println("\n\n--------------Upi payment ------------------- ");
	 context.setPaymentContext(new UPIPayment("Tnx-12323234"));
	 context.processPayment(new PayInformation(4000, "INR"));
	 
     
 }
}
   