import static org.junit.Assert.*;

import org.junit.Test;


public class Problem1 {

	/*
	  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

	  Find the sum of all the multiples of 3 or 5 below 1000.
	 * */

	@Test
	public void test() {
		assertEquals(0, natural35Sum(0));
		assertEquals(0, natural35Sum(2));
		assertEquals(23, natural35Sum(10));
		assertEquals(14, natural35Sum(9));
		assertEquals(33, natural35Sum(11));
		assertEquals(233168, natural35Sum(1000));
	}


	// easy case with 3 and 5
	private int natural35Sum(int maximumNumber) {
		int sum = 0;
		for (int i = 0; i < maximumNumber; i++) {
			if(shouldWeAddCurrentInteger(i)) {
				sum+= i;
			}
		}
		return sum;
	}

	private boolean shouldWeAddCurrentInteger(int i) {
		return i%3 == 0 || i%5 == 0;
	}





	// to go further

	@Test
	public void furtherTest() throws Exception {
		int[] multiples = new int[]{3,5};
		assertEquals(0, naturalSum(0, multiples));
		assertEquals(23, naturalSum(10, multiples));
		assertEquals(14, naturalSum(9, multiples));
		assertEquals(33, naturalSum(11, multiples));
		assertEquals(233168, naturalSum(1000, multiples));
		
		multiples = new int[]{7};
		assertEquals(0, naturalSum(0, multiples));
		assertEquals(0, naturalSum(6, multiples));
		assertEquals(7, naturalSum(10, multiples));
		assertEquals(71071, naturalSum(1000, multiples));
		
	}
	


	private int naturalSum(int maximumNumber, int[] multiplesToConsider) throws Exception {
		chekcInput(maximumNumber, multiplesToConsider);

		int sum = 0;

		for (int i = 0; i < maximumNumber; i++) {
			if(shouldWeAddCurrentInteger(i, multiplesToConsider)) {
				sum+= i;
			}
		}
		return sum;
	}


	private boolean shouldWeAddCurrentInteger(int currentInteger, int[] multiplesToConsider) {
		boolean b = false;
		for (int currentMultiple : multiplesToConsider) {
			if (currentInteger % currentMultiple == 0) { // if at least one is true, we add currentNumber to sum
				b = true;
			}
		}
		return b;
	}

	
	
	
	
	
	private static String MAX_SHOULD_NOT_BE_NEGATIVE = "maximumNumber should not be negative";
	private static String MULTIPLES_SHOULD_NOT_BE_NULL = "multiplesToConsider should not be null";
	private static String MULTIPLES_SHOULD_NOT_BE_EMPTY = "multiplesToConsider should not be empty";
	private static String MULTIPLES_SHOULD_CONTAIN_ONLY_POSITIVE_VALUES = "multiplesToConsider should contain only positive values";

	@Test
	public void furtherTest_chekcInput() throws Exception {

		testCheckInputWith(-5, new int[]{7}, MAX_SHOULD_NOT_BE_NEGATIVE);
		testCheckInputWith(5, null, MULTIPLES_SHOULD_NOT_BE_NULL);
		testCheckInputWith(5, new int[]{}, MULTIPLES_SHOULD_NOT_BE_EMPTY);
		testCheckInputWith(5, new int[]{7, 0}, MULTIPLES_SHOULD_CONTAIN_ONLY_POSITIVE_VALUES);
		testCheckInputWith(5, new int[]{7, -5}, MULTIPLES_SHOULD_CONTAIN_ONLY_POSITIVE_VALUES);
	}


	private void testCheckInputWith(int max, int[] multiples, String expectedExceptionMessage) {
		try {
			naturalSum(max, multiples);
			fail();
		}
		catch(Exception e) {
			assertEquals(expectedExceptionMessage, e.getMessage());
		}
	}
	
	
	private void chekcInput(int maximumNumber, int[] multiplesToConsider) throws Exception {
		if (maximumNumber < 0) {
			throw new Exception(MAX_SHOULD_NOT_BE_NEGATIVE);
		}
		if (multiplesToConsider == null) {
			throw new Exception(MULTIPLES_SHOULD_NOT_BE_NULL);
		}
		if (multiplesToConsider.length == 0) {
			throw new Exception(MULTIPLES_SHOULD_NOT_BE_EMPTY);
		}
		for (int i : multiplesToConsider) {
			if (i <= 0) {
				throw new Exception(MULTIPLES_SHOULD_CONTAIN_ONLY_POSITIVE_VALUES);
			}
		}
	}
}

