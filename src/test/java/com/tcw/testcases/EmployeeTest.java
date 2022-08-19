package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.EmployeePage;

public class EmployeeTest extends LogInTest {

	EmployeePage ep;
	
	@Test(priority=1)
	public void landingOnEmployeePage() {
		logIn();
		ep = new EmployeePage(driver);
		String empTtl1 = ep.goToEmployeePage();
		Assert.assertEquals(empTtl1, "Employee");
	}
	
}
