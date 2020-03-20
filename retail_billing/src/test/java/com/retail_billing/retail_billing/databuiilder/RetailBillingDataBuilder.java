package com.retail_billing.retail_billing.databuiilder;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.retail_billing.retail_billing.pojo.Item;
import com.retail_billing.retail_billing.pojo.Product;
import com.retail_billing.retail_billing.pojo.RetailCustomer;
import com.retail_billing.retail_billing.pojo.RetailCustomerType;

public class RetailBillingDataBuilder {
	
	private static final int CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU12344345");
		product.setName("SpiderManStickers");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("MKU99999999");
		product.setName("Oats");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	public static RetailCustomer getAffiliateRetailCustomer() {
		RetailCustomer customer = new RetailCustomer(RetailCustomerType.AFFILIATE, "testCustomer001", "TEST Affiliate", new DateTime().minusYears(3));
		return customer;
	}
	
	public static RetailCustomer getEmployeeRetailCustomer() {
		RetailCustomer customer = new RetailCustomer(RetailCustomerType.EMPLOYEE, "testCustomer1101", "bISWAJIT", new DateTime().minusYears(3));
		return customer;
	}
	
	public static RetailCustomer getRetailCusWithMoreThanTwoYearRegistration() {
		RetailCustomer customer = new RetailCustomer(RetailCustomerType.CUSTOMER, "testCustomer1234", "CHIRANJIT", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return customer;
	}
	
	public static RetailCustomer getRetailCusWithLessThanTwoYearRegistration() {
		RetailCustomer customer = new RetailCustomer(RetailCustomerType.CUSTOMER, "testCustomer124", "XYZ", new DateTime().minusYears(CUSTOMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return customer;
	}
	
	public static Item getItemWithDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	public static Item getItemWithNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getItemWithDiscountableProduct(10));
		items.add(getItemWithNonDiscountableProduct(5));
		return items;
	}
}
