package handlingframes;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindowsDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();

		// Now, focus on 2nd window.

		Set<String> windowsId = driver.getWindowHandles();
		List<String> listWindowId = new ArrayList<String>(windowsId);
		System.out.println(listWindowId.get(0));
		System.out.println(listWindowId.get(1));
		String parentWindowId = listWindowId.get(0);
		String childWindowId = listWindowId.get(1);
		// focus on 2nd window:
		driver.switchTo().window(childWindowId);

		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();

		driver.switchTo().window(parentWindowId);

		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]")).sendKeys("admin123");

		// close particular window

		for (String winId : windowsId) {
			String title = driver.switchTo().window(winId).getTitle();
			if (title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.close();
			}
		}

		System.out.println("Case passed");

	}

}
