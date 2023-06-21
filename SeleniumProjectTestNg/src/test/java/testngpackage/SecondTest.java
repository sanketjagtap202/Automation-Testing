package testngpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SecondTest {

	WebDriver driver;

	@Test(priority = 1)
	public void openApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

	}

	@Test(priority = 2)
	void login() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority = 3)
	void logout() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();

	}
}
