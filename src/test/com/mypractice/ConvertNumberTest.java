package test.com.mypractice;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import com.mypractice.ConvertNumber;

public class ConvertNumberTest {

	public static ConvertNumber convertNumber;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convertNumber = new ConvertNumber();
	}

	@Test
	public void testBinaryToDecimal() {
		assertEquals(7, convertNumber.binaryToDecimal(111));
		assertEquals(61, convertNumber.binaryToDecimal(111101));
	}

	@Test (expected = IllegalArgumentException.class)
	public void testBinaryToDecimal1() {
		assertEquals(7, convertNumber.binaryToDecimal(111));
		assertEquals(61, convertNumber.binaryToDecimal(1211101));
	}
	@Test
	public void testDecimalToBinary() {
		assertEquals("111", convertNumber.decimalToBinary(7));
		assertEquals("110100", convertNumber.decimalToBinary(52));
	}

	
}
