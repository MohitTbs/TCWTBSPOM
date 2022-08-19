package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.DashboardPage;
import com.tcw.pages.NotClockedInNowPage;

public class NotClockedInNowTest extends LogInTest{

	DashboardPage dashp;
	NotClockedInNowPage ncinp;
	
	@Test(priority=1)
	public void notClockedInTest() {
		logIn();
		dashp = new DashboardPage(driver);
		ncinp = new NotClockedInNowPage(driver);
		ncinp=dashp.goToNotClockedInNowPage();
		String nameText1 = ncinp.notclockedInTest();
		Assert.assertEquals(nameText1, "Name");
		
	}
}
