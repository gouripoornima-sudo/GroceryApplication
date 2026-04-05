package testScripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;


import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import automationCore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

public class AdmiUsersTest extends Base {
	HomePage home;
    AdminUsersPage admin;
	

	@Test(priority = 1, description = "Validating new user entry")
	public void verifyAddNewUser() throws IOException {

		FakerUtility faker = new FakerUtility();
		String newUsername = faker.createRandomUsername();
		String newPassword = faker.createRandomPassword();
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

	    LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		//HomePage home = new HomePage(driver);
		admin=home.adminUsersButton();

		//AdminUsersPage admin = new AdminUsersPage(driver); [Chaining Methods]
		admin.clickNewUserButton().enterUsername(newUsername).enterPassword(newPassword).selectUserType("Admin").clickSaveButton();

		// Assertions
		boolean alertDisplay = admin.isAlertDisplayed();
		AssertJUnit.assertEquals(alertDisplay, Constant.UserEntryError);
	}

	@Test(priority = 2, description = "Validating user details search")
	public void verifySearchButtonandResetButton() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		//HomePage home = new HomePage(driver);
		admin=home.adminUsersButton();

		//AdminUsersPage admin = new AdminUsersPage(driver);

		admin.clickSearchIcon().enterSearchUsername("Poornima").selectSearchUserType("Admin").clickSearchButton().clickResetButton();

		// Assertions
		boolean usersList = admin.adminUsersList();
		Assert.assertEquals(usersList, Constant.UserSearchError);
	}

	@Test(priority = 3, description = "Validating user's Reset Button")
	public void verifyResetButton() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		//HomePage home = new HomePage(driver);
		admin=home.adminUsersButton();

		//AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickMainResetButton();

		// Assertions
		boolean resetList = admin.adminUsersList();
		Assert.assertTrue(resetList, Constant.UserResetError);
	}

}
