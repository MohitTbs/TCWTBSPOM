package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.LiveStreamPage;

public class LiveStreamTest extends LogInTest {
	
	DashboardPage dasp;
	LiveStreamPage lsp;
	
	@Test(priority=1)
	public void liveStreamTest(){
		logIn();
		dasp =  new DashboardPage(driver);
		lsp = new LiveStreamPage(driver);
		dasp.goToLiveStreamPage();
		String activityText1 = lsp.liveStream();
		Assert.assertEquals(activityText1, "ACTIVITY INFORMATION");
		
		
	}

}
