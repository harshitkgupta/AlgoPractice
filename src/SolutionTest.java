import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
	
	@Test
	public void testEmptyArrayRotate()
	{
		List<Integer> arr = new ArrayList<Integer>();
		ThoughtWorks.rotateArrary(arr, 1);
		List<Integer> expected = new ArrayList<Integer>();
		Assert.assertEquals(arr, expected);
	}
	
	@Test
	public void testArrayRotateByZero()
	{		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		int shift = 0;
		ThoughtWorks.rotateArrary(arr, shift);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		Assert.assertEquals(arr, expected);
	}
	
	@Test
	public void testArrayRotateByArraySize()
	{
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		int shift = arr.size();
		ThoughtWorks.rotateArrary(arr, shift);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		Assert.assertEquals(arr, expected);
	}
	
	@Test
	public void testArrayRotateByOne()
	{
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		int shift = 1;
		ThoughtWorks.rotateArrary(arr, shift);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(3);
		expected.add(1);
		Assert.assertEquals(arr, expected);
	}
	
	@Test
	public void testArrayRotateByArraySizeMinusOne()
	{
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		int shift = arr.size()-1;
		ThoughtWorks.rotateArrary(arr, shift);
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(4);
		expected.add(1);
		expected.add(2);
		expected.add(3);
		Assert.assertEquals(arr, expected);
	}
}
