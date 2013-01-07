import static org.junit.Assert.*;

import org.junit.Test;


public class Problem4 {

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
		
		int[] multiples = new int[]{3,5};
		assertEquals(23, naturalSum(10, multiples));
		assertEquals(14, naturalSum(9, multiples));
		assertEquals(33, naturalSum(11, multiples));
		assertEquals(233168, naturalSum(1000, multiples));
	}

	// more global case
	private int naturalSum(int number, int[] multiples) {
		int sum = 0;
		boolean b;
		
		for (int currentNumber = 0; currentNumber < number; currentNumber++) {
			b = false;
			for (int currentMultiple : multiples) {
				if (currentNumber % currentMultiple == 0) { // if at least one is true, we add currentNumber to sum
					b = true;
				}
			}
			if(b) {
				sum+= currentNumber;
			}
		}
		return sum;
	}
	
	
	// easy case with 3 and 5
	private int natural35Sum(int number) {
		int sum = 0;
		for (int i = 0; i < number; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum+= i;
			}
		}
		return sum;
	}

}
