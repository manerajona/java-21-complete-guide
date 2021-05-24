package com.primes;

import org.openjdk.jmh.annotations.Benchmark;

public class PrimeBenchmarking {
	
	
	@Benchmark
	public void version1() {
		Main v1main = new Main();
		try {
			v1main.version1();
		} catch (InterruptedException e) {
			
		}
	}
	
	@Benchmark
	public void version2() {
		Main v2main = new Main();
		try {
			v2main.version2();
		} catch (InterruptedException e) {
			
		}
	}
}
