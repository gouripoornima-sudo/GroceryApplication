package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;

public class HomeTest extends Base {
	@Test(description = "Validating successful logout of user",retryAnalyzer =retryMechanism.Retry.class)
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		HomePage home = new HomePage(driver);
		home.clickAdminButton();
		home.clickLogoutButton();
	}

}
