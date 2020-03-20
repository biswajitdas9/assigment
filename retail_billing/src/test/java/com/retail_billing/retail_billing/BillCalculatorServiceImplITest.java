package com.retail_billing.retail_billing;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.retail_billing.retail_billing.databuiilder.RetailBillingDataBuilder;
import com.retail_billing.retail_billing.pojo.Item;
import com.retail_billing.retail_billing.pojo.RetailCustomer;
import com.retail_billing.retail_billing.service.BillCalculatorService;
import com.retail_billing.retail_billing.service.BillCalculatorServiceImpl;



public class BillCalculatorServiceImplITest {
	
	private BillCalculatorService billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		billCalculatorService = new BillCalculatorServiceImpl();
		items = RetailBillingDataBuilder.getItemListWithMultipleProducts();
	}
	
	@Test
	public void shouldCalculateBillForDiscountEligible() {
		RetailCustomer customer = RetailBillingDataBuilder.getRetailCusWithMoreThanTwoYearRegistration();
		Assert.assertEquals(761.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillForNonEligible() {
		RetailCustomer customer = RetailBillingDataBuilder.getRetailCusWithLessThanTwoYearRegistration();
		Assert.assertEquals(790.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	@Test
	public void shouldCalculateBillforAffiliate() {
		RetailCustomer affiliateCustomer = RetailBillingDataBuilder.getAffiliateRetailCustomer();
		Assert.assertEquals(737.00, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0);
	}

}
