package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base {
	HomePage home;
	@Test(description = "Validating successful logout of user",retryAnalyzer =retryMechanism.Retry.class)
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		//HomePage home = new HomePage(driver);
		home.clickAdminButton();
		home.clickLogoutButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.UnsuccessfulLogoutError);
		
	}

}
