package com.ramantrehan.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestSmallestElement {
	public List<Integer> findNearestSmallestElement(List<Integer> arr) {
		//nearest smallest element to left
		List<Integer> nearestSmallestElements = new ArrayList<>();
		
		if(arr == null || arr.size() == 0) {
			return nearestSmallestElements;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int n = arr.size();
		for(int i = 0; i<n; i++) {
			while(!stack.isEmpty() && stack.peek() >= arr.get(i)) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				nearestSmallestElements.add(-1);
			} else {
				nearestSmallestElements.add(stack.peek());
			}
			
			stack.push(arr.get(i));
 		}
		
		return nearestSmallestElements;
	}
}
