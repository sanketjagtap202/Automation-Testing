package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchBox {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.orangehrm.com/");
		driver.manage().timeouts().getImplicitWaitTimeout();
		Duration.ofSeconds(3);
		driver.findElement(By.id("Form_submitForm_EmailHomePage")).sendKeys("sanketjagtap202@gmail.com");
		driver.findElement(By.xpath("//input[@id='Form_submitForm_action_request']")).click();
		driver.findElement(By.id("Form_getForm_Name")).sendKeys("Sanket Jagtap");
		driver.findElement(By.id("Form_getForm_Email")).sendKeys("sanketjagtap202@gmail.com");
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("8530589695");
		
		driver.quit();

	}

}
