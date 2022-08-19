package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.ReportsPage;

public class ReportsTest extends LogInTest {
	
	ReportsPage rp;
	
	@Test(priority=1)
	public void landingOnReportsPage() {
		logIn();
		rp = new ReportsPage(driver);
		String reportsTtl1 = rp.goToReportsPage();
		Assert.assertEquals(reportsTtl1, "Reports");
	}

}
