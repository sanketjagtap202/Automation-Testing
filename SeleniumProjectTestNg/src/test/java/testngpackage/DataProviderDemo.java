package testngpackage;

import org.testng.annotations.BeforeClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviderDemo {

	WebDriver driver;

	@BeforeClass
	public void setupApp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Test(dataProvider = "dp")
	void login(String email, String pwd) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(act_title, exp_title);

	}

	@AfterClass
	void logoutApp() {
		driver.close();
	}

	@DataProvider(name = "dp")
	String[][] loginData() {
		String data[][] =
			{ 
				{ "abc@gmail.com", "test123" },
				{ "pavanol@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test3" },
				{ "abc@gmail.com", "test123" },
				{ "pavanoltraining@gmail.com", "test@123" },
				
			};
		return data;

	}

}
