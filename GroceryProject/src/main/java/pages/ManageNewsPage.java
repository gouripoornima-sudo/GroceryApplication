package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Add New News
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newNewsButton;

	@FindBy(id = "news")
	WebElement newsField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveButton;

	// Search News
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIcon;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchNewsField;

	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;

	// Reset
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetButton;

	// Assertion Elements
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;

	@FindBy(xpath = "//h4[text()='Manage News']")
	WebElement manageNewsTitle;

	@FindBy(id = "news")
	WebElement newsInputField;
	

	// Click New News button
	public ManageNewsPage clickNewNewsButton() {
		newNewsButton.click();
		return this;
	}

	// Enter news
	public ManageNewsPage enterNews(String news) {
		newsField.sendKeys(news);
		return this;
	}

	// Click Save
	public ManageNewsPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	// Click Search icon
	public ManageNewsPage clickSearchIcon() {
		searchIcon.click();
		return this;
	}
	

	// Enter news in search field
	public ManageNewsPage enterNewsInSearchField(String news) {
		searchNewsField.sendKeys(news);
		return this;
	}

	// Click Search button
	public ManageNewsPage clickSearchButton() {
		searchButton.click();
		return this;
	}

	// Click Reset button
	public ManageNewsPage clickResetButton() {
		resetButton.click();
		return this;
	}

	// Verify alert message
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}

	// Verify search result page
	public boolean isManageNewsPageDisplayed() {
		return manageNewsTitle.isDisplayed();
	}

	// Verify reset action
	public boolean isResetSuccessful() {
		return newsInputField.isDisplayed();
	}
}
