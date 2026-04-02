package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'and contains(@class,'dropdown-item')]")
	WebElement logoutButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class,'small-box-footer')]")
	WebElement adminUsersButton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='active nav-link']")
	WebElement manageNewsIcon;
	// Assertion
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pageText;

	public HomePage clickAdminButton() {
		adminButton.click();
		return this;
	}

	public LoginPage clickLogoutButton() {
		logoutButton.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage adminUsersButton() {
		adminUsersButton.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickManageNewsIcon() {
		manageNewsIcon.click();
		return new ManageNewsPage(driver);
	}

	// Assertion

	public String getPageText() {
			return pageText.getText();

}
}
