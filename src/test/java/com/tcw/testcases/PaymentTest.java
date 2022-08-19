package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.PaymentPage;

public class PaymentTest extends LogInTest {
	
	PaymentPage pp;
	
	@Test(priority=1)
	public void landingOnPaymentPage() {
		logIn();
		pp = new PaymentPage(driver);
		String paymentTtl1 = pp.goToPaymentPage();
		Assert.assertEquals(paymentTtl1, "Payment");
	}

}
