package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {

	WebDriver driver;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newUserButton;

	@FindBy(name = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(id = "user_type")
	WebElement userTypeDropdown;

	@FindBy(name = "Create")
	WebElement saveButton;

	@FindBy(id = "un")
	WebElement searchUsernameField;

	@FindBy(id = "ut")
	WebElement searchUserTypeDropdown;

	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchIcon;

	@FindBy(name = "Search")
	WebElement searchButton;

	@FindBy(xpath = "(//a[contains(@href,'list-admin') and @class='btn btn-default btn-fix'])[1]")
	WebElement resetButton;

	@FindBy(xpath = "//a[contains(@class,'btn-warning')]")
	WebElement mainResetButton;

	public void clickNewUserButton() {
		newUserButton.click();
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void selectUserType(String type) {
		Select select = new Select(userTypeDropdown);
		select.selectByVisibleText(type);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void addNewUser(String username, String password, String type) {
		clickNewUserButton();
		enterUsername(username);
		enterPassword(password);
		selectUserType(type);
		clickSaveButton();
	}

	public void clickSearchIcon() {
		searchIcon.click();
	}

	public void enterSearchUsername(String username) {
		searchUsernameField.sendKeys(username);
	}

	public void selectSearchUserType(String type) {
		Select select = new Select(searchUserTypeDropdown);
		select.selectByVisibleText(type);
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickResetButton() {
		resetButton.click();
	}

	public void clickMainResetButton() {
		mainResetButton.click();
	}
}