package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.SelfRegistrationRequestsPage;

public class SelfRegistrationRequestsTest extends LogInTest{
	
	DashboardPage dashp;
	SelfRegistrationRequestsPage srrp;
	
	@Test(priority=1)
	public void selfRegUserTest() {
		logIn();
		dashp = new DashboardPage(driver);
		srrp = new SelfRegistrationRequestsPage(driver);
		srrp=dashp.goToSelfRegistrationRequestsPage();
		String dateText1=srrp.selfRegUserSrch();
		Assert.assertEquals(dateText1, "Date");
		
	}

}
