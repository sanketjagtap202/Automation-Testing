package testngpackage;

import org.testng.Assert;
import org.testng.annotations.*;

public class DependMethodsTest {
	@Test(priority = 1)
	public void openApp() {
		Assert.assertTrue(true);

	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	void login() {

		Assert.assertTrue(true);
	}

	@Test(priority = 3, dependsOnMethods = { "login" })
	void search() {

		Assert.assertTrue(true);
	}

	@Test(priority = 4, dependsOnMethods = { "login", "search" })
	void advSearch() {

		Assert.assertTrue(false);
	}

	@Test(priority = 5, dependsOnMethods = { "login" })
	void logout() {

		Assert.assertTrue(true);

	}

}
