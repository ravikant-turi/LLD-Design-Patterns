package com.java.main;

public class NotificationFactory {

	
	
	public Notification createNotification(String type) {
		if(type.equalsIgnoreCase("EMAIL")) {
			return new EmailNotification();
		}
		else if(type.equalsIgnoreCase("WAP")) {
			return new WhatsAppNotification();
			
		}
		else if(type.equalsIgnoreCase("SMS")) {
			return new SMSNotification();
		}
		else {
			System.out.println("Invalid input");
			return null;
		}
	}

}
