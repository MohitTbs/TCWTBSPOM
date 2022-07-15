package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.ReimbursementRequestsPage;

public class ReimbursementRequestsTest extends LogInTest{

	DashboardPage dashp;
	ReimbursementRequestsPage rrp;
	
	@Test(priority=1)
	public void reimReqSrcTest() {
		logIn();
		dashp= new DashboardPage(driver);
		rrp = new ReimbursementRequestsPage(driver);
		rrp=dashp.goToReimbursementRequestsPage();
		String dateText1=rrp.reimbReqSrch();
		Assert.assertEquals(dateText1, "Date");
	}
	
}
