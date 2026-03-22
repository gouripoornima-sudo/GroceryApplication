package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="username") WebElement usernamefield;
	@FindBy(name="password") WebElement passwordfield;
	@FindBy(xpath="//button[text()='Sign In']") WebElement submittbutton;


	public void enterUsernameOnUsernameField(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void enterPasswordOnPasswordField(String password)
	{
		passwordfield.sendKeys(password);
	}
	public void clickLoginButton()
	{
		submittbutton.click();
	}

}
