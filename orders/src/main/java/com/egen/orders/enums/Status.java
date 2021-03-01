package com.egen.orders.enums;

public enum Status {
	STARTED("STARTED"),
	COMPLETED("COMPLETED"),
	CANCELLED("CANCELLED");
	
	private String message;
	
	Status(String s){
		this.message = s;
	}
	
	public String getStatus() {
		return message;
	}
}
