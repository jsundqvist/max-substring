package code.challenge;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import code.challenge.MaxSubstring;

public class MaxSubstringTest {

	@BeforeSuite
	public void beforeTest() {
		new MaxSubstring();
	}

	@DataProvider
	public Object[][] testGetMaxSubstringProvider() {
		return new Object[][] {
				{ "Initial challenge", "abbcda", "bcda" }
				, { "The whole string", "abcdefg", "abcdefg" }
				, { "Equal-length substrings", "ababcdabdcba", "abcd" }
				, { "Overlapping substrings", "abcdaefghij", "bcdaefghij" }
		};
	}

	@Test(dataProvider = "testGetMaxSubstringProvider")
	public void testGetMaxSubstring10(String message, String input, String expected) {
		String actual = MaxSubstring.getMaxSubstring10(input);
		Assert.assertEquals(actual, expected, message);
	}

	@Test(dataProvider = "testGetMaxSubstringProvider")
	public void testGetMaxSubstring11(String message, String input, String expected) {
		String actual = MaxSubstring.getMaxSubstring11(input);
		Assert.assertEquals(actual, expected, message);
	}

	@Test(dataProvider = "testGetMaxSubstringProvider")
	public void testGetMaxSubstring20(String message, String input, String expected) {
		String actual = MaxSubstring.getMaxSubstring20(input);
		Assert.assertEquals(actual, expected, message);
	}

	@Test
	public void testMaxSubstringLength() {
		int maxSubstringLength = MaxSubstring.getMaxSubstringLength("abbcda");
		Assert.assertEquals(maxSubstringLength, 4);
	}

}
