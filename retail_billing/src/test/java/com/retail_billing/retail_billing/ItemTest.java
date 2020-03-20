package com.retail_billing.retail_billing;

import org.junit.Assert;
import org.junit.Test;

import com.retail_billing.retail_billing.databuiilder.RetailBillingDataBuilder;
import com.retail_billing.retail_billing.pojo.Item;
import com.retail_billing.retail_billing.pojo.Product;

public class ItemTest {
	
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = RetailBillingDataBuilder.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = RetailBillingDataBuilder.getDiscountableProduct();
		Item item = new Item(product, 6);
		Assert.assertEquals(330.54, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = RetailBillingDataBuilder.getDiscountableProduct();
		Item item = new Item(product, 7);
		Assert.assertEquals(405.93, item.getDiscountedPrice(0), 0);
		
	}

}
