package scripts;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin(){
		LoginPage lp = new LoginPage(driver);
		int rowCount = Lib.getRowCount("InvalidLogin");
		for (int i = 1; i <= rowCount; i++) {
			String username = Lib.getCellValue("InvalidLogin", i, 0);
			//enter invalid username
			lp.setUsername(username);
			//enter invalid password
			String password = Lib.getCellValue("InvalidLogin", i, 1);
			lp.setPassword(password);
			//click on Login button 
			lp.clickLogin();
		}
	}
}
