package pageobjectclasspattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLoginPage {

	public WebDriver driver;

	public SwagLoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators:

	By txt_username = By.id("user-name");
	By txt_password = By.id("password");
	By btn_login = By.xpath("//input[@id='login-button']");

	// Actions:

	public void setUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}

	public void setPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
}
