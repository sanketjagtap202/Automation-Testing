package testngpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;

	@BeforeClass
	@Parameters({"browser"})
	void setup(String value) throws InterruptedException {
		if(value.equals("chrome"))
			
		{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}else if(value.equals("edge")) {
			driver= new EdgeDriver();
			driver.manage().window().maximize();
		}else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void checkLoginPage() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
		boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		}catch(Exception e ) {
			Assert.fail();
		}
	}
	@Test(priority = 2)
	void testTitle() {
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title not matched..");
	}
	
	@AfterClass
	void closeApp() {
		driver.close();
	}
}
