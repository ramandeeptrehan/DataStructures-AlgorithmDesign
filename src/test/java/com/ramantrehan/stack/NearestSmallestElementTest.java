package com.ramantrehan.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NearestSmallestElementTest {
	private NearestSmallestElement obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new NearestSmallestElement();
	}
	
	@Test
	public void testValidInputList() {
		List<Integer> arr = Arrays.asList(4, 5, 2, 10, 8);
		List<Integer> nearestSmallestElements = obj.findNearestSmallestElement(arr);
		
		List<Integer> expected = Arrays.asList(-1, 4, -1, 2, 2);
		
		assertEquals(expected, nearestSmallestElements);
	}
	
	@Test
	public void testDecresingOrderList() {
		List<Integer> arr = Arrays.asList(3, 2, 1);
		List<Integer> nearestSmallestElements = obj.findNearestSmallestElement(arr);
		
		List<Integer> expected = Arrays.asList(-1, -1, -1);
		
		assertEquals(expected, nearestSmallestElements);
	}
	
	@Test
	public void testForEmptyList() {
		List<Integer> arr = Arrays.asList();
		List<Integer> nearestSmallestElements = obj.findNearestSmallestElement(arr);
		
		List<Integer> expected = Arrays.asList();
		
		assertEquals(expected, nearestSmallestElements);
	}
	
	@Test
	public void testForNullList() {
		List<Integer> arr = null;
		List<Integer> nearestSmallestElements = obj.findNearestSmallestElement(arr);
		
		List<Integer> expected = Arrays.asList();
		
		assertEquals(expected, nearestSmallestElements);
	}
}
