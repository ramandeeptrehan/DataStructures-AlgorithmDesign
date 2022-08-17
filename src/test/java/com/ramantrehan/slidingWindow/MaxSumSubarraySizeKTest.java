package com.ramantrehan.slidingWindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaxSumSubarraySizeKTest {

	private MaxSumSubarraySizeK obj;
	
	@BeforeEach
	public void setup() {
		obj = new MaxSumSubarraySizeK();
	}
	
	@Test
	public void testValidScenarios() {
		
		int[] arr = {2, 5, 1, 8, 2, 9, 1};
		int k = 3;
		
		assertEquals(19, obj.computeMaxSumSubarraySizeK(arr, k));
		
		k = 1;
		assertEquals(9, obj.computeMaxSumSubarraySizeK(arr, k));
	}
	
	@Test
	public void testEmptyArray() {
		
		assertThrows(RuntimeException.class, () -> {
			obj.computeMaxSumSubarraySizeK(new int[0], 10);
		});
	}
	
	@Test
	public void testNullArray() {
		
		assertThrows(RuntimeException.class, () -> {
			obj.computeMaxSumSubarraySizeK(null, 10);
		});
	}
}
