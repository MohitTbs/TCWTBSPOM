package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.PossibleClockInErrorsPage;

public class PossibleClockInErrorsTest extends LogInTest{
	
	DashboardPage dashp;
	PossibleClockInErrorsPage pciep;
	@Test
	public void possClockInErrListTest() {
		logIn();
		
		dashp = new DashboardPage(driver);
		pciep = new PossibleClockInErrorsPage(driver);
		pciep=dashp.goToPossibleClockInErrorsPage();
		String ttl=pciep.getTtlPossClockInErr();
		Assert.assertEquals(ttl, "Possible Clock In Errors List");
		
	}

}
