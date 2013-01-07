import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Problem3 {

	/*
	The prime factors of 13195 are 5, 7, 13 and 29.
	
	What is the largest prime factor of the number 600851475143 ?
	 * */

	@Test
	public void testPrime() {
		assertEquals(true, isPrime(1));
		assertEquals(true, isPrime(2));
		assertEquals(true, isPrime(3));
		assertEquals(false, isPrime(4));
		assertEquals(false, isPrime(6));
		assertEquals(true, isPrime(13));
		assertEquals(true, isPrime(7));
		assertEquals(false, isPrime(9));
		assertEquals(false, isPrime(new Long("600851475143")));
		System.out.println(primeNumbers.toString());
		
	}
	
	
	@Test
	public void testHighestPrime() {
		assertEquals(7, getHighestPrime(14));
		assertEquals(3, getHighestPrime(81));
		assertEquals(2, getHighestPrime(4));
		assertEquals(6857, getHighestPrime(new Long("600851475143")));
	}

	
	private long getHighestPrime(long number) {
		long result = 0;
		long currentNumber = 2;
		while(currentNumber <= number) {
			if (isPrime(currentNumber) && number % currentNumber == 0) {
				number = number / currentNumber;
				result = currentNumber;
				currentNumber --; // 20 = 5 * 2 * 2 so we should consider a divider several times
			}
			currentNumber ++;
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	private ArrayList<Long> primeNumbers = new ArrayList<Long>();
	private boolean isPrime(long number) {
		if (number == 1) {
			return true;
		}
		
		long prime;
		// check list from 2 to square root of number
		for (int i = 0; i < primeNumbers.size(); i++) {
			prime = primeNumbers.get(i);
			if (prime * prime > number) { // stop if we reach square root of number
				return true;
			}
			if (number % prime == 0) { // false if is not prime
				return false;
			}
		}
		
		// add to the list the primes until square root of number
		long start = (primeNumbers.size() > 0)? primeNumbers.get(primeNumbers.size()-1) : 2;
		for (long nextNumber = start; nextNumber < number; nextNumber++) {
			if (isPrime(nextNumber)) {
				if (!primeNumbers.contains(nextNumber)) {
					primeNumbers.add(nextNumber);
				}
				if (nextNumber * nextNumber > number) { // stop if we reach square root of number
					return true;
				}
				if (number % nextNumber == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
