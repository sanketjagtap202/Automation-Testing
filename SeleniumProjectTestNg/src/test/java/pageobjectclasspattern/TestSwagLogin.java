package pageobjectclasspattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSwagLogin {

	WebDriver driver;
	SwagLoginPage clp;

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/");
	}

	@Test(priority = 1)
	void testLogin() throws InterruptedException {
		clp = new SwagLoginPage(driver);
		
		
		clp.setUsername("standard_user");
		
		clp.setPassword("secret_sauce");
		
		clp.clickLogin();

		// Validations:
		
		Assert.assertEquals(driver.getTitle(), "Swag Labs");

	}

	@AfterClass
	void closeApp() {
		driver.quit();
	}

}
