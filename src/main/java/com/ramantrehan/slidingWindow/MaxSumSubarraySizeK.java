package com.ramantrehan.slidingWindow;

public class MaxSumSubarraySizeK {
	public int computeMaxSumSubarraySizeK(int[] arr, int k) {
		
		if(arr == null || arr.length == 0) {
			throw new RuntimeException("Array is null or empty");
		}
				
		int windowStart = 0;
		int windowEnd = 0;
		int currentSum = 0;
		int maxSubarraySum = Integer.MIN_VALUE;

		int n = arr.length;
		
		while(windowEnd < n) {
			currentSum += arr[windowEnd];
			
			if(windowEnd - windowStart + 1 == k) {
				maxSubarraySum = Math.max(currentSum, maxSubarraySum);
				
				//remove windowStart element contribution and update the pointer
				currentSum -= arr[windowStart];
				windowStart++;
			}
			
			windowEnd++;
		}
		
		return maxSubarraySum;
	}
}
