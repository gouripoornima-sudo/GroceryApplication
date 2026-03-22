package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.ExcelUtility;
import automationCore.Base;
import pages.LoginPage;

public class LoginTest extends Base {
	@Test
	public void verifyUserLoginwithValidCredentials() throws IOException
	{
		//WebElement usernamefield=driver.findElement(By.id("user-name"));
		//usernamefield.sendKeys("standard_user");
		//WebElement passwordfield =driver.findElement(By.id("password"));
		//passwordfield.sendKeys("secret_sauce");
		//WebElement submittbutton=driver.findElement(By.id("login-button"));
		//submittbutton.click();
		String username=ExcelUtility.readStringData(0, 0, "Login Page");
		String password=ExcelUtility.readStringData(0, 1, "Login Page");
		LoginPage login=new LoginPage(driver);
        login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	@Test
	public void verifyUserLoginwithInvalidCredentials() throws IOException
	{
		String username=ExcelUtility.readStringData(1, 0, "Login Page");
		String password=ExcelUtility.readStringData(1, 1, "Login Page");
		LoginPage login=new LoginPage(driver);
        login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	@Test
	public void verifyLoginwithInvalidUsername() throws IOException
	{
		String username=ExcelUtility.readStringData(2, 0, "Login Page");
		String password=ExcelUtility.readStringData(2, 1, "Login Page");
		LoginPage login=new LoginPage(driver);
        login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	@Test
	public void verifyLoginwithInvalidPassword() throws IOException
	{
		String username=ExcelUtility.readStringData(3, 0, "Login Page");
		String password=ExcelUtility.readStringData(3, 1, "Login Page");
		LoginPage login=new LoginPage(driver);
        login.enterUsernameOnUsernameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}


}
