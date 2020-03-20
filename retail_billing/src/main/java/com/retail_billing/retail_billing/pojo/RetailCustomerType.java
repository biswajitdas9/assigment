package com.retail_billing.retail_billing.pojo;

public enum RetailCustomerType {
	
	AFFILIATE(10),EMPLOYEE(30),CUSTOMER(5);
	
	private double discountPercentage;
	
	RetailCustomerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public double getDiscountPercentage() {
		return discountPercentage;
	}

}
