package scripts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;
public class TestValidLogin extends BaseTest{
	
	Logger log = LogManager.getLogger(TestValidLogin.class.getName());
	@Test
	public void testValidLogin(){
		
		
		log.debug("Creating an object of LoginPage pom class");
		LoginPage lp = new LoginPage(driver);
		log.info("Object created successfully");
		//enter username
		log.debug("Retrieving the username from excel sheet");
		String username = Lib.getCellValue("ValidLogin", 1, 0);
		log.info("username value retrieved successfully");
		lp.setUsername(username);
		//enter password
		String password = Lib.getCellValue("ValidLogin", 1, 1);
		lp.setPassword(password);
		//click on login button
		lp.clickLogin();
		//Verify Home page is displayed
		String expectedTitle = Lib.getCellValue("ValidLogin", 1, 2);
		//Expected Condition :Wait till home page title is displayed
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleIs(expectedTitle));
		String actualTitle = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		s.assertAll();
	}
}
