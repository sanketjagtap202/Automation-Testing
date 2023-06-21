package testngpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo1 {

	WebDriver driver;
	

	@BeforeClass
	void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}

	@Test(dataProvider="dp")
	public void testLogin(String user, String pwd) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(user);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		String act_title= driver.getTitle();
		String exp_title="OrangeHRM";
		Assert.assertEquals(act_title, exp_title);

	}
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
	
	@DataProvider(name="dp", indices= {0,1})
	String[][] loginData() {
		String data[][]= {
				{"Admin", "admin123"},
				{"Admins", "admin123"},
				{"Admin", "admin12@3"},
				{"admin", "admin@123"},
				
		};
		return data;
		
	}
	
}
