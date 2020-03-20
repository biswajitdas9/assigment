package com.retail_billing.retail_billing.service;

import java.util.List;

import com.retail_billing.retail_billing.pojo.Item;
import com.retail_billing.retail_billing.pojo.RetailCustomer;

public interface BillCalculatorService {
	
	double calculateTotalPayableAmount(RetailCustomer customer, List<Item> items);

}
