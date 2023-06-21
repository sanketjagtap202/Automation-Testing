package testngpackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotationsTest {
	@BeforeMethod
	public void openApp() {
		System.out.println("this is before method");
	}

	@Test
	void login() {
		System.out.println("This is test method");
	}

	@AfterMethod
	void logout() {
		System.out.println("This is after method");
	}

	@BeforeClass
	void m1() {
		System.out.println("This is before class");
	}

	@AfterClass
	void m2() {
		System.out.println("This is after class");
	}

	@BeforeTest
	void m3() {
		System.out.println("This is before test");
	}

	@AfterTest
	void m4() {
		System.out.println("This is after class");
	}

	@BeforeSuite
	void m5() {
		System.out.println("This is before suite");
	}

	@AfterSuite
	void m6() {
		System.out.println("This is after suite");
	}
}
