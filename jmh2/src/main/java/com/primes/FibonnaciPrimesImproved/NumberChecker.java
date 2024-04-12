package com.primes.FibonnaciPrimesImproved;

import java.util.stream.IntStream;

public class NumberChecker {

	public Boolean isPrime1(Integer testNumber) {
		for (Integer i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
	public Boolean isPrime2(int testNumber) {
		int maxToCheck = (int)Math.sqrt(testNumber);
		return IntStream.rangeClosed(2, maxToCheck).noneMatch(i -> testNumber % i == 0);
	}
	
	
}
