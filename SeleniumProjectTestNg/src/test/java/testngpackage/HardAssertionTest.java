package testngpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertionTest {
	@Test
	public void f() {

		int a = 10;
		int b = 20;
		/*
		 * if(a==b) { System.out.println("test passed"); } else {
		 * System.out.println("Test failed"); }
		 */

		Assert.assertEquals(a, b);

	}
}
