import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.tcw.base.BaseTest;
import com.tcw.pages.DashboardPage;
import com.tcw.pages.LoginPage;

public class LogInTest extends BaseTest {

	
	

	

	LoginPage lp;
	DashboardPage dashp;
	
	@Test(priority=1)
	public void logIn() {
		
	lp.loginIn();
		
		
		
	}
	
}
