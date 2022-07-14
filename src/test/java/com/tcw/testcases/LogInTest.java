package com.tcw.testcases;

import com.tcw.base.BasePage;
import com.tcw.pages.DashboardPage;
import com.tcw.pages.LoginPage;

public class LogInTest extends BasePage {

	LoginPage lp;
	DashboardPage dashp;

	//@Test(priority = 1)
	public void logIn1() {
		log.info("In login 1");
		lp = new LoginPage(driver);
		lp.loginIn();

	}
	
	public void logIn() {
		log.info("In login 2");
		lp = new LoginPage(driver);
		lp.loginIn();

	}

}
