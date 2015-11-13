package test.com.mypractice;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mypractice.NumberOfDigitOne;

public class NumberOfDigitOneTest {

	public NumberOfDigitOne numberOfDigitOne;
	
	@Before
	public void setUp() throws Exception {
		numberOfDigitOne = new NumberOfDigitOne();
	}

		
	@Test
	public void testCountDigitOne(){
		//assertEquals(0,numberOfDigitOne.countDigitOne(0));
		assertEquals(22,numberOfDigitOne.countDigitOne(10));
				
	}

/*	@Test
	public void TestIsPowerOfTwo(){
		assertEquals(true, numberOfDigitOne.isPowerOfTwo(1));
	}*/
	
/*	@Test
	public void testTwoSum() {
		assertArrayEquals(new int[]{3,4},numberOfDigitOne.twoSum(new int []{1,2,4,5},9));
	}*/
}
