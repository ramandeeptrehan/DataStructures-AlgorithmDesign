package com.ramantrehan.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {
	public int countOccurrencesOfAnagrams(String text, String word) {
		
		Map<Character, Integer> map = new HashMap<>();
		char ch = ' ';
		for(int i = 0; i<word.length(); i++) {
			ch = word.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
				
		int numberOfAnagrams = 0;		
		int windowStart = 0;
		int windowEnd = 0;
		
		int n = text.length();
		
		int count = map.size();
		int windowLength = word.length();
		char windowStartChar = ' ';
		char windowEndChar = ' ';
				
		while(windowEnd < n) {
			//consider windowEnd character
			windowEndChar = text.charAt(windowEnd);
			
			if(map.containsKey(windowEndChar)) {
				map.put(windowEndChar, map.get(windowEndChar) - 1);
				
				if(map.get(windowEndChar) == 0) {
					count--;
				}
			}
			
			//window has been hit
			if(windowEnd - windowStart + 1 == windowLength) {
				if(count == 0) {
					numberOfAnagrams++;
				}
				
				windowStartChar = text.charAt(windowStart);
				
				//remove windowStart contribution
				if(map.containsKey(windowStartChar)) {
					
					map.put(windowStartChar, map.get(windowStartChar) + 1);
					
					//don't check > 0 condition, since it will do count++ for cases when value goes from 1 to 2 as well.
					//we want to increment count only when map's value goes from 0 to 1
					if(map.get(windowStartChar) == 1) {
						count++;
					}
				}
				
				windowStart++;
			}
			
			windowEnd++;
		}
		
		return numberOfAnagrams;
	}
}
