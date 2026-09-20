package com.skillexchange.entity;

public enum Role {
	ROLE_USER("Standard User"),
	ROLE_GUEST("Guest"),
	ROLE_PREMIUM_MEMBER("Premium User"),
	ROLE_ADMIN("Admin");
	
	private final String displayLabel;
	
	Role(String displayLabel){
		this.displayLabel = displayLabel;
	}
	
	public String getDisplayLabel() {
		return this.displayLabel;
	}
}