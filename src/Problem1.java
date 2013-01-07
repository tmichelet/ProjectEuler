import static org.junit.Assert.*;

import org.junit.Test;


public class Problem1 {

	/*
	  If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

	  Find the sum of all the multiples of 3 or 5 below 1000.
	 * */
	
	@Test
	public void test() {
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
	public void furtherTest() {
		int[] multiples = new int[]{3,5};
		assertEquals(23, naturalSum(10, multiples));
		assertEquals(14, naturalSum(9, multiples));
		assertEquals(33, naturalSum(11, multiples));
		assertEquals(233168, naturalSum(1000, multiples));
	}

	
	private int naturalSum(int maximumNumber, int[] multiplesToConsider) {
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
}
