package accoliteHiring.sumOfDigits;

import org.junit.Assert;
import org.junit.Test;

import honeywell.stampthematrix.TestClass;

public class TestCase {
	@Test
	public void test(){
		Assert.assertEquals(TestClass.getStampCount(3, 5, 14),12);
		Assert.assertEquals(TestClass.getStampCount(4, 4, 10),9);
		Assert.assertEquals(TestClass.getStampCount(1000000, 12345, 1000000000000L),12345000000L);
		
		Assert.assertEquals(TestClass.getStampCount(1000, 10000, 5000),5000);
		Assert.assertEquals(TestClass.getStampCount(1, 1000, 900),900);
		Assert.assertEquals(TestClass.getStampCount(20, 25, 500),500);
		Assert.assertEquals(TestClass.getStampCount(10, 5, 25),25);
	}
}
