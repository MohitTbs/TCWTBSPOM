package com.tcw.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.EmployeePage;
import com.tcw.utilities.DataUtil;

public class EmployeeTest extends LogInTest {

	EmployeePage ep;
	
	@Test(priority=1)
	public void landingOnEmployeePage() {
		logIn();
		ep = new EmployeePage(driver);
		String empTtl1 = ep.goToEmployeePage();
		Assert.assertEquals(empTtl1, "Employee");
	}

	
	@Test(priority=2)
	public void globalSettingTest() {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		ep.globalSettingTesting();
	}
	
	@Test(priority=3, dataProviderClass = DataUtil.class, dataProvider = "dp2" , enabled=true)
	public void reimbursementTest(Hashtable<String,String> data) {
		logIn();
		ep = new EmployeePage(driver);
		ep.goToEmployeePage();
		String txt=ep.reimbursementTesting(data);
		Assert.assertTrue(txt.contains("Total"));
	}
}
