package com.ramantrehan.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	String[] mappings = {
	        "0",
	        "1",
	        "abc",
	        "def",
	        "ghi",
	        "jkl",
	        "mno",
	        "pqrs",
	        "tuv",
	        "wxyz"
	    };
	    
    private void buildLetterCombinations(String digits, int currentIndex, String currentString, List<String> result) {
        if(currentIndex == digits.length()) {
            result.add(currentString);
            return;
        }
        
        int letterIndex = digits.charAt(currentIndex) - '0';
        String letters = mappings[letterIndex];
        
        for(char ch: letters.toCharArray()) {
            buildLetterCombinations(digits, currentIndex+1, currentString + ch, result);
        }
    }
    
    public List<String> letterCombinations(String digits) {
                
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.length() == 0) {
            return result;
        }
        
        buildLetterCombinations(digits, 0, "", result);
        return result;
    }
}
