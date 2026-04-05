package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.PageUtility;

public class AdminUsersPage {

	WebDriver driver;
	PageUtility page=new PageUtility();

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

	// Reset WebElements

	@FindBy(xpath = "(//a[contains(@href,'list-admin') and @class='btn btn-default btn-fix'])[1]")
	WebElement resetButton;

	@FindBy(xpath = "//a[contains(@class,'btn-warning')]")
	WebElement mainResetButton;

	// Assertion

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;

	@FindBy(xpath = "//h4[text()='Admin Users']")
	WebElement usersList;

	public AdminUsersPage clickNewUserButton() {
		newUserButton.click();
		return this;
	}

	public AdminUsersPage enterUsername(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	public AdminUsersPage enterPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public AdminUsersPage selectUserType(String type) {
		page.selectDropdownWithText(searchUserTypeDropdown, type);
		//Select select = new Select(userTypeDropdown);
		//select.selectByVisibleText(type);
		return this;
	}

	public AdminUsersPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public AdminUsersPage addNewUser(String username, String password, String type) {
		clickNewUserButton();
		enterUsername(username);
		enterPassword(password);
		selectUserType(type);
		clickSaveButton();
		return this;
	}

	public AdminUsersPage clickSearchIcon() {
		searchIcon.click();
		return this;
	}

	public AdminUsersPage enterSearchUsername(String username) {
		searchUsernameField.sendKeys(username);
		return this;
	}

	public AdminUsersPage selectSearchUserType(String type) {
		Select select = new Select(searchUserTypeDropdown);
		select.selectByVisibleText(type);
		return this;
	}

	public AdminUsersPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	// Reset the AdminUsers Page
	public AdminUsersPage clickResetButton() {
		resetButton.click();
		return this;
	}

	public AdminUsersPage clickMainResetButton() {
		mainResetButton.click();
		return this;
	}

	// Assertion
	public boolean isAlertDisplayed() {
		return AlertMsg.isDisplayed();
	}

	public boolean adminUsersList() {
		return usersList.isDisplayed();
	}
}