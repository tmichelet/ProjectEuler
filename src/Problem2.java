import static org.junit.Assert.*;

import org.junit.Test;


public class Problem2 {

	/*
	  Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

	1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

	By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

	 * */

	@Test
	public void testFibonacci() {
		assertEquals(2, fibonacciEvenSum(3));
		assertEquals(10, fibonacciEvenSum(8));
		assertEquals(10, fibonacciEvenSum(21));
		assertEquals(4613732, fibonacciEvenSum(4000000));
	}

	private int fibonacciEvenSum(int maxNumberAllowed) {
		
		if (maxNumberAllowed < 2) {
			return 0;
		}
		if (maxNumberAllowed < 4) {
			return 2;
		}
		
		int sum = 2;
		int n = 2, n_1 = 1, n_2;

		while(true) {
			n_2 = n_1;
			n_1 = n;
			n = n_1 + n_2;
			if (n > maxNumberAllowed) {
				return sum;
			}
			if (n % 2 == 0) {
				sum += n;
			}
		}
	}

}
