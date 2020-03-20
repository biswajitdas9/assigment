package com.retail_billing.retail_billing.pojo;

import org.joda.time.DateTime;

public class RetailCustomer {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	private RetailCustomerType customerType;
	
	private String customerID;
	
	private String customerName;
	
	private DateTime registrationDate;
	
	public RetailCustomer(RetailCustomerType customerType, String customerID, String customerName, DateTime registrationDate) {
		super();
		this.customerType = customerType;
		this.customerID = customerID;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
	}

	public RetailCustomerType getCustomerType() {
		return customerType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public DateTime getRegistrationDate() {
		return registrationDate;
	}
	
	public boolean isAvailableForLoyaltyDiscount() {
		DateTime dateToCompare = DateTime.now().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS);
		return registrationDate.isBefore(dateToCompare) && (RetailCustomerType.CUSTOMER == customerType);
	}
}
