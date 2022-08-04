package com.tcw.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tcw.pages.PayrollPage;

public class PayrollTest extends LogInTest{

	PayrollPage pp;

	@Test(priority=1)
	public void landingOnPayrollPage() {
		logIn();
		pp = new PayrollPage(driver);
		String payrollTtl = pp.goToPayrollPage();
		Assert.assertEquals(payrollTtl,"Payroll" );
		
	}
	
}
