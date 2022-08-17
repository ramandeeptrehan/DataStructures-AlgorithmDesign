package com.ramantrehan.slidingWindow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstNegativeNumberInEverySubarraySizeKTest {
	
	private FirstNegativeNumberInEverySubarraySizeK obj;
	
	@BeforeEach
	public void setup() {
		obj = new FirstNegativeNumberInEverySubarraySizeK();
	}
	
	@Test
	public void testValidScenarios() {
		int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		int k = 3;
		
		int[] expectedResult = {-1, -1, -7, -15, -15, 0};
		
		int[] result = obj.firstNegativeNumberInEverySubarraySizeK(arr, k);
		
		//assertEquals cannot be used since arrays in memory are different
		//assertEquals(expectedResult, result);
		
		//to do exact matching of values, use assertArrayEquals. It does array content comparison.
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testValidScenariosAnotherExample() {
		int[] arr = {-8, 2, 3, -6, 10};
		int k = 2;
		
		int[] expectedResult = {-8, 0, -6, -6};
		
		int[] result = obj.firstNegativeNumberInEverySubarraySizeK(arr, k);
		
		assertArrayEquals(expectedResult, result);
	}
	
	@Test
	public void testEmptyArray() {
		
		assertThrows(RuntimeException.class, () -> {
			obj.firstNegativeNumberInEverySubarraySizeK(new int[0], 10);
		});
	}
	
	@Test
	public void testNullArray() {
		
		assertThrows(RuntimeException.class, () -> {
			obj.firstNegativeNumberInEverySubarraySizeK(null, 10);
		});
	}
}
