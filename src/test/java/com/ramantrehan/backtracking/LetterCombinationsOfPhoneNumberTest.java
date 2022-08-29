package com.ramantrehan.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LetterCombinationsOfPhoneNumberTest {
	private LetterCombinationsOfPhoneNumber obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new LetterCombinationsOfPhoneNumber();
	}
	
	@Test
	public void testPhoneNumberLetterCombinations() {
		String digits = "23";
		
		List<String> expected = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
		assertEquals(expected, obj.letterCombinations(digits));
	}
	
	@Test
	public void testPhoneNumberLetterCombinationsEmptyDigits() {
		String digits = "";
		
		List<String> expected = new ArrayList<>();
		assertEquals(expected, obj.letterCombinations(digits));
	}
	
	@Test
	public void testPhoneNumberLetterCombinationsSingleDigit() {
		String digits = "2";
		
		List<String> expected = Arrays.asList("a", "b", "c");
		assertEquals(expected, obj.letterCombinations(digits));
	}
}
