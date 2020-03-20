package com.retail_billing.retail_billing.service;

import java.util.List;

import com.retail_billing.retail_billing.pojo.Item;
import com.retail_billing.retail_billing.pojo.RetailCustomer;
import com.retail_billing.retail_billing.pojo.RetailCustomerType;

public class BillCalculatorServiceImpl implements BillCalculatorService {

	private static final int DISCOUNT_PER_HUNDRED = 5;

	public double calculateTotalPayableAmount(RetailCustomer customer, List<Item> items) {
		double totalDiscountedPrice = 0;
		double discountPercentage = getDiscountPercentageForCustomer(customer);
		for(Item item:items) {
			totalDiscountedPrice = totalDiscountedPrice + item.getDiscountedPrice(discountPercentage);
		}
		 
		return Math.round(totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice));
	}


	private double getDiscountPercentageForCustomer(RetailCustomer customer) {
		RetailCustomerType customerType = customer.getCustomerType();
		if(customerType == RetailCustomerType.AFFILIATE || customerType == RetailCustomerType.EMPLOYEE || customer.isAvailableForLoyaltyDiscount()) {
			return customerType.getDiscountPercentage();
		}
		return 0;
	}
	
	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}
}
