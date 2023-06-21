package pageobjectclasspattern;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {

	WebDriver driver;

	LoginPage lp;

	@BeforeClass()
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

//	@Test(priority = 1)
//	void testLogo() {
//		lp = new LoginPage(driver);
//		Assert.assertEquals(lp.setLogo(), true);
//
//	}

	@Test(priority = 2)
	void Login() {
		lp = new LoginPage(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.clickSubmit();
		Assert.assertEquals(driver.getCurrentUrl(),
				"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

	}
	@AfterClass
	void closeLoginTest() {
		driver.quit();
	}

}
