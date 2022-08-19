package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.TimesheetsToVerifyPage;

public class TimesheetsToVerifyTest extends LogInTest {

	
	DashboardPage dashp;
	TimesheetsToVerifyPage ttvp;
	
	@Test(priority=1)
	public void verifiedClockInTest() {
		logIn();
		dashp = new DashboardPage(driver);
		ttvp=new TimesheetsToVerifyPage(driver);
		ttvp=dashp.goToTimesheetsToVerifyPage();
		String nameText1=ttvp.verifiedClockIn();
		Assert.assertEquals(nameText1, "Name");
		
		
		
	}
	
	
}
