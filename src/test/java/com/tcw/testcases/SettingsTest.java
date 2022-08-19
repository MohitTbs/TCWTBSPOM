package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.SettingsPage;

public class SettingsTest extends LogInTest {
	
	SettingsPage sp;
	
	@Test(priority=1)
	public void landingOnSettingsPage() {
		logIn();
		sp = new SettingsPage(driver);
		String settTtl1 = sp.goToSettingsPage();
		Assert.assertEquals(settTtl1, "Settings");
	}
}
