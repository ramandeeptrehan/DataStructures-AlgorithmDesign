package com.ramantrehan.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NextGreaterElementTest {
	private NextGreaterElement obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new NextGreaterElement();
	}
	
	@Test
	public void testValidCase1() {
		List<Integer> arr = Arrays.asList(4, 5, 2, 10);
		List<Integer> nextGreaterElements = obj.findNextGreaterElement(arr);
		
		List<Integer> expected = Arrays.asList(5, 10, 10, -1);
		
		assertEquals(expected, nextGreaterElements);
	}
	
	@Test
	public void testDecresingOrderList() {
		List<Integer> arr = Arrays.asList(3, 2, 1);
		List<Integer> nextGreaterElements = obj.findNextGreaterElement(arr);
		
		List<Integer> expected = Arrays.asList(-1, -1, -1);
		
		assertEquals(expected, nextGreaterElements);
	}
	
	@Test
	public void testForEmptyList() {
		List<Integer> arr = Arrays.asList();
		List<Integer> nextGreaterElements = obj.findNextGreaterElement(arr);
		
		List<Integer> expected = Arrays.asList();
		
		assertEquals(expected, nextGreaterElements);
	}
	
	@Test
	public void testForNullList() {
		List<Integer> arr = null;
		List<Integer> nextGreaterElements = obj.findNextGreaterElement(arr);
		
		List<Integer> expected = Arrays.asList();
		
		assertEquals(expected, nextGreaterElements);
	}
}
