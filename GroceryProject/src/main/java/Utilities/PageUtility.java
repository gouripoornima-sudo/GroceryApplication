package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithText(WebElement element, String text) {

		Select object = new Select(element);
		object.selectByVisibleText(text);
	}

	public void selectDropdownWithIndex(WebElement element, int index) {

		Select object = new Select(element);
		object.selectByIndex(index);
	}

	public void rightClickOnElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void mouseHoverOnElement(WebDriver driver, WebElement element) {

		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
}
