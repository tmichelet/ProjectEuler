import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Problem3 {

	/*
	The prime factors of 13195 are 5, 7, 13 and 29.

	What is the largest prime factor of the number 600851475143 ?
	 * */

	@Test
	public void testPrime() throws Exception {
		assertEquals(true, isPrime(1));
		assertEquals(true, isPrime(2));
		assertEquals(true, isPrime(3));
		assertEquals(false, isPrime(4));
		assertEquals(false, isPrime(6));
		assertEquals(true, isPrime(13));
		assertEquals(true, isPrime(7));
		assertEquals(false, isPrime(9));
		assertEquals(false, isPrime(new Long("600851475143")));
		try {
			isPrime(-1);
			fail();
		} catch (Exception e) {
			assertEquals(MAX_SHOULD_NOT_BE_NEGATIVE, e.getMessage());
		}
	}

	private static String MAX_SHOULD_NOT_BE_NEGATIVE = "maximumNumber should not be negative";

	
	
	private ArrayList<Long> primeNumbers = new ArrayList<Long>(); 
	// to store the prime number already found. By construction, they are ascending ordered

	
	
	private boolean isPrime(long number) throws Exception {
		if (number < 0) {
			throw new Exception(MAX_SHOULD_NOT_BE_NEGATIVE);
		}
		if (number == 1) {
			return true;
		}

		long prime;

		// check prime list we have from 2 to square root of number
		for (int i = 0; i < primeNumbers.size(); i++) {
			prime = primeNumbers.get(i);
			if (prime * prime > number) { 
				// if we reach square root of number, it means that we found no prime factor, so it is a prime number
				return true;
			}
			if (number % prime == 0) { 
				// false if we find a prime factor
				return false;
			}
		}

		
		
		// check all the prime numbers that aren't in the list, but are under the number's square root
		// btw, add them in the list
		long start = (primeNumbers.size() > 0)? primeNumbers.get(primeNumbers.size()-1) : 2;
		for (long nextNumber = start; nextNumber < number; nextNumber++) {
			if (isPrime(nextNumber)) {
				if (!primeNumbers.contains(nextNumber)) {
					primeNumbers.add(nextNumber);
				}
				if (nextNumber * nextNumber > number) { 
					// if we reach square root of number, it means that we found no prime factor, so it is a prime number
					return true;
				}
				if (number % nextNumber == 0) {
					// false if we find a prime factor
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * NB: there is some code duplication. There must be a better way.
	 *
	 */




	@Test
	public void testHighestPrime() throws Exception {
		assertEquals(7, getHighestPrime(14));
		assertEquals(3, getHighestPrime(81));
		assertEquals(2, getHighestPrime(4));
		assertEquals(6857, getHighestPrime(new Long("600851475143")));
	}


	private long getHighestPrime(long number) throws Exception {
		long result = 0;
		long currentNumber = 1;
		while(currentNumber < number) {
			currentNumber ++;
			if (isPrime(currentNumber) && number % currentNumber == 0) {
				number = number / currentNumber;
				result = currentNumber;
				currentNumber --; // 20 = 5 * 2 * 2 so we should consider a divider several times
			}
		}

		return result;
	}



}
