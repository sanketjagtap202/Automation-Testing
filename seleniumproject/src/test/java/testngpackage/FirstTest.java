package testngpackage;

import org.testng.annotations.Test;

public class FirstTest {
	@Test(priority = 1)
	public void f() {
		System.out.println("Testing f");
	}

	@Test(priority = 2)
	public void f2() {

		System.out.println("Testing f2");
	}

	@Test(priority = 3)
	public void f3() {
		System.out.println("Testing f3");
	}
}
