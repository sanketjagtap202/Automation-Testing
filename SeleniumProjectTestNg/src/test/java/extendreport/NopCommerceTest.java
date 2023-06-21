package extendreport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NopCommerceTest {

	WebDriver driver;

	@Test(priority = 1)
	void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 2, dependsOnMethods = { "setup" })
	void TestLogo() {

		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();

		Assert.assertEquals(status, true);
	}

	@Test(priority = 3)
	void TestLogin() {
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("Password")).sendKeys("test123");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		// validation:
		boolean status = driver.findElement(By.linkText("My account")).isDisplayed();

		Assert.assertEquals(status, true);
	}

	@Test(priority = 4, dependsOnMethods = { "TestLogin" })
	void TestLogout() throws InterruptedException {

		driver.findElement(By.linkText("Log out")).click();

		// validation:
		boolean status = driver.findElement(By.linkText("Register")).isDisplayed();

		Assert.assertEquals(status, true);
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	void closeApp() {
		driver.close();
	}

}
