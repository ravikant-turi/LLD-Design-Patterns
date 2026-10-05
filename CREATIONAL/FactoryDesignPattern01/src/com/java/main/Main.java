package com.java.main;

 

public class Main {
	
	public static void main(String[] args) {
		
		String type="EMAIL";
		
		NotificationFactory factory=new NotificationFactory();
		
	   Notification notification=	factory.createNotification(type);
	   
	   notification.send();
	}

}
