package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']") WebElement adminButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and contains(@class,'dropdown-item')]")WebElement logoutButton;
	public void clickAdminButton()
	{
		adminButton.click();
	}
	public void clickLogoutButton()
	{
	   logoutButton.click();
	}

}
