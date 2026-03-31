package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import Utilities.FakerUtility;
import automationCore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;

public class AdmiUsersTest extends Base {

	@Test
	public void verifyAddNewUser() throws IOException {
		FakerUtility faker = new FakerUtility();
		String newUsername = faker.createRandomUsername();
		String newPassword = faker.createRandomPassword();
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.adminUsersButton();

		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickNewUserButton();
		admin.enterUsername(newUsername);
		admin.enterPassword(newPassword);
		admin.selectUserType("Admin");
		admin.clickSaveButton();
	}

	@Test
	public void verifySearchButtonandResetButton() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.adminUsersButton();

		AdminUsersPage admin = new AdminUsersPage(driver);

		admin.clickSearchIcon();
		admin.enterSearchUsername("Poornima");
		admin.selectSearchUserType("Admin");
		admin.clickSearchButton();
		admin.clickResetButton();
	}

	@Test
	public void verifyResetButton() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.adminUsersButton();

		AdminUsersPage admin = new AdminUsersPage(driver);

		admin.clickMainResetButton();
	}

}
