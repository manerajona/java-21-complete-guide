package com.manerajona.jvm.performance.measures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumbers {

	private Boolean isPrime(Integer testNumber) {
		return IntStream.range(2, testNumber).noneMatch(i -> testNumber % i == 0);
	}
	
	private Integer getNextPrimeAbove(Integer previous) {
		Integer testNumber = previous + 1;
		while (!isPrime(testNumber)) testNumber++;
		return testNumber;
	}
	
	public void generateNumbers (Integer max) {
		List<Integer> primes = new ArrayList<>();
		primes.add(2);

		Integer next = 2;
		while (primes.size() <= max) {
			next = getNextPrimeAbove(next);
			primes.add(next);
		}
	}

}
