package com.primes;

import org.openjdk.jmh.annotations.Benchmark;

import java.util.stream.IntStream;

public class PrimeBenchmarking {
	public Boolean isPrime1(Integer testNumber) {
		for (Integer i = 2; i < testNumber; i++) {
			if (testNumber % i == 0) return false;
		}
		return true;
	}
	
	public Boolean isPrime2(int testNumber) {
		int maxToCheck = (int)Math.sqrt(testNumber);
		return IntStream
				.rangeClosed(2, maxToCheck)
				.noneMatch(i -> testNumber % i == 0);
	}
	
	@Benchmark
	public void version1() {
		for (int i = 1; i < 50000; i++) {
			isPrime1(i);
		}
	}
	
	@Benchmark
	public void version2() {
		for (int i = 1; i < 50000; i++) {
			isPrime2(i);
		}
	}
}
