package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import automationCore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends Base {
	HomePage home;
	@Test(priority = 1, description = "Validating user login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginwithValidCredentials() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constant.ValidCredsError);
	}

	@Test(priority = 2, description = "Validating user login with invalid credentials", groups = {
			"smoke" }, dataProvider = "loginProvider")
	public void verifyUserLoginwithInvalidCredentials(String username, String password) throws IOException {

		// String username = ExcelUtility.readStringData(1, 0, "Login Page");
		// String password = ExcelUtility.readStringData(1, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();

		String actual = login.getPageText();
		String expected = "7rmart supermarket";

		Assert.assertEquals(actual, expected, Constant.InvalidCredsError);
	}

	@Test(priority = 3, description = "Validating login with invalid username")
	public void verifyLoginwithInvalidUsername() throws IOException {

		String username = ExcelUtility.readStringData(2, 0, "Login Page");
		String password = ExcelUtility.readStringData(2, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();

		String actual = login.getPageText();
		String expected = "7rmart supermarket";

		Assert.assertEquals(actual, expected, Constant.InvalidUsernameError);
	}

	@Test(priority = 4, description = "Validating login with invalid password")
	public void verifyLoginwithInvalidPassword() throws IOException {

		String username = ExcelUtility.readStringData(3, 0, "Login Page");
		String password = ExcelUtility.readStringData(3, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLoginButton();

		String actual = login.getPageText();
		String expected = "7rmart supermarket";

		Assert.assertEquals(actual, expected, Constant.InvalidPasswordError);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
				// new Object[] {ExcelUtility.getStringData(3,
				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
	}
}
