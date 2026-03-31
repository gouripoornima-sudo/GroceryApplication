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
	public void clickNewNewsButton() {
		newNewsButton.click();
	}

	// Enter news
	public void enterNews(String news) {
		newsField.sendKeys(news);
	}

	// Click Save
	public void clickSaveButton() {
		saveButton.click();
	}

	// Click Search icon
	public void clickSearchIcon() {
		searchIcon.click();
	}

	// Enter news in search field
	public void enterNewsInSearchField(String news) {
		searchNewsField.sendKeys(news);
	}

	// Click Search button
	public void clickSearchButton() {
		searchButton.click();
	}

	// Click Reset button
	public void clickResetButton() {
		resetButton.click();
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
