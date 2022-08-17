package com.ramantrehan.slidingWindow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class CountOccurrencesOfAnagramsTest {
	private CountOccurrencesOfAnagrams obj;
	
	@BeforeEach
	public void setup() {
		obj = new CountOccurrencesOfAnagrams();
	}
	
	@Test
	public void testValidScenario1() {
		
		String text = "forxxorfxdofr";
		String word = "for";
		
		assertEquals(3, obj.countOccurrencesOfAnagrams(text, word));
	}
	
	@Test
	public void testValidScenario2() {
		
		String text = "aabaabaa";
		String word = "aaba";
		
		assertEquals(4, obj.countOccurrencesOfAnagrams(text, word));
	}
}
