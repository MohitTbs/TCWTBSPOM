import org.testng.annotations.Test;
import com.tcw.base.BasePage;
import com.tcw.pages.DashboardPage;
import com.tcw.pages.LoginPage;

public class LogInTest extends BasePage {

	LoginPage lp;
	DashboardPage dashp;

	@Test(priority=1)
	public void logIn() {
		lp= new LoginPage(driver);
		lp.loginIn();
		
		
		
	}
	
}
