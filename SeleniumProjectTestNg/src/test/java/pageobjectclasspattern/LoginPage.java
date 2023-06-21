package pageobjectclasspattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public WebDriver driver;

	// Constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// Locators:
	By img_logo = By.xpath("//img[@alt='company-branding']");
	By txt_username = By.name("username");
	By txt_password = By.name("password");
	By btn_submit = By.xpath("//button[normalize-space()='Login']");

	// Actions:

	public boolean setLogo() {
		boolean status = driver.findElement(img_logo).isDisplayed();
		return status;
	}
	
	
	public void setUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(btn_submit).click();
	}
}
