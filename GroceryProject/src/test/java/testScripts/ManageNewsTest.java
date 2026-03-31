package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import automationCore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;

public class ManageNewsTest extends Base {

	@Test(priority = 1, description = "Verify user is able to add new news")
	public void verifyAddNewNews() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickManageNewsIcon();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickNewNewsButton();
		news.enterNews("Gold Rate at Its Peak");
		news.clickSaveButton();

		boolean alert = news.isAlertMessageDisplayed();
		Assert.assertTrue(alert, "News not added successfully");
	}

	@Test(priority = 2, description = "Verify user is able to search news")
	public void verifySearchNews() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickManageNewsIcon(); // clickManageNewsIcon

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickSearchIcon();
		news.enterNewsInSearchField("Gold");
		news.clickSearchButton();

		boolean searchResult = news.isManageNewsPageDisplayed();
		Assert.assertTrue(searchResult, "Search failed");
	}

	@Test(priority = 3, description = "Verify reset functionality")
	public void verifyResetNews() throws IOException {

		String username = ExcelUtility.readStringData(0, 0, "Login Page");
		String password = ExcelUtility.readStringData(0, 1, "Login Page");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickManageNewsIcon();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickResetButton();

		boolean reset = news.isResetSuccessful();
		Assert.assertTrue(reset, "Reset failed");
	}
}
