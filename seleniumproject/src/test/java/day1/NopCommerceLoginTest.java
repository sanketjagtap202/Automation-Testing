package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
----------------
1) Launch browser
2) open url
	URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
3) Provide username  - admin@yourstore.com
4) Provide password  - admin
5) Click on Login button 
6) Verify the title of dashboard page   
	Exp title : Dashboard / nopCommerce administration
7) Verify Dasboad
 */

public class NopCommerceLoginTest {

	public static void main(String[] args) throws InterruptedException {
//		1) Launch browser:
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

//open url
		// URL: https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F

		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(5000);

		// Provide username - admin@yourstore.com
		WebElement txtemail = driver.findElement(By.name("Email"));
		txtemail.clear();
		Thread.sleep(2000);
		txtemail.sendKeys("admin@yourstore.com");

		// Provide password - admin
		WebElement txtpassword = driver.findElement(By.name("Password"));
		txtpassword.clear();
		Thread.sleep(2000);
		txtpassword.sendKeys("admin123");

		// 5) Click on Login button
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();

		// Verify the title of dashboard page
		// Exp title : Dashboard / nopCommerce administration
		String act_title = driver.getTitle();
		String exp_title = "Dashboard / nopCommerce administration";
		if (act_title.equals(exp_title)) {
			System.out.println("Test pass");
		} else {
			System.out.println("Test failed");
		}
	}

}
