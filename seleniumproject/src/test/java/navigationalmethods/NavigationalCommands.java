package navigationalmethods;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // oragehrm
		System.out.println(driver.getCurrentUrl());
		driver.navigate().to("https://www.amazon.in/"); // amazon
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back(); // orangehrm
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward(); // amazn
		System.out.println(driver.getCurrentUrl()); // amazon
		driver.navigate().refresh();
		System.out.println("Refreshed url: " + driver.getCurrentUrl());

	}

}
