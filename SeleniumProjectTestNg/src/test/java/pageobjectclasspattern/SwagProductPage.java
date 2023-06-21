package pageobjectclasspattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagProductPage extends SwagLoginPage {

	public SwagProductPage(WebDriver driver) {
		super(driver);

	}

	// locators:
	By link_txt = By.linkText("Sauce Labs Backpack");
	By btn_addCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");

	// Actions:

	public void clickLinkText() {
		driver.findElement(link_txt).click();
	}

	public void clickAddCart() {
		driver.findElement(btn_addCart).click();
	}

}
