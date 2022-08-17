package com.ramantrehan.slidingWindow;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeNumberInEverySubarraySizeK {
	public int[] firstNegativeNumberInEverySubarraySizeK(int[] arr, int k) {
		
		if(arr == null || arr.length == 0) {
			throw new RuntimeException("Array is null or empty");
		}
		
		int n = arr.length;
		
		int[] negativeNumbers = new int[n-k+1];
		int index = 0;
		
		int windowStart = 0;
		int windowEnd = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		while(windowEnd < n) {
			if(arr[windowEnd] < 0) {
				queue.add(arr[windowEnd]);
			}
			
			if(windowEnd - windowStart + 1 == k) {
				if(queue.isEmpty()) {
					negativeNumbers[index++] = 0;
				} else {
					negativeNumbers[index++] = queue.peek();
				}
				
				//update windowStart and remove its effect
				if(!queue.isEmpty() && queue.peek() == arr[windowStart]) {
					queue.remove();
				}
				
				windowStart++;
			}
			
			windowEnd++;
		}
		
		return negativeNumbers;
	}
}
