package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.PendingTimesheetRequestsPage;

public class PendingTimesheetRequestsTest extends LogInTest{

	PendingTimesheetRequestsPage ptr;
	DashboardPage dashp;
	
	@Test(priority=1)
	public void timesheetRequestListTest() {
		logIn();
		dashp = new DashboardPage(driver);
		
		ptr = new PendingTimesheetRequestsPage(driver);
		ptr=dashp.goToPendingTimesheetReq();
		String tsReqLstTtl1 =ptr.timesheetRequestList();
		Assert.assertEquals(tsReqLstTtl1, "Naxme");
		
	}
	
	
	
}
