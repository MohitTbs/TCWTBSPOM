package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SupportPage;

public class SupportTest extends LogInTest {

	SupportPage sp;

	@Test(priority = 1)
	public void landingOnSupportPage() {
		logIn();
		sp = new SupportPage(driver);
		String supportTtl1 = sp.goToSupportPage();
		Assert.assertEquals(supportTtl1, "Support");
	}
	
}
