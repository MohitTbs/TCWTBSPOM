package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SchedulePage;

public class ScheduleTest extends LogInTest {

	SchedulePage sp;

	@Test(priority = 1)
	public void landingOnSchedulePage() {

		logIn();
		sp = new SchedulePage(driver);
		String schdTtl1 = sp.goToSchedulePage();
		Assert.assertEquals(schdTtl1, "Schedule");
		
	}

}
