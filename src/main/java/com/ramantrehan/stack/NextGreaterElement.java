package com.ramantrehan.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {
	public List<Integer> findNextGreaterElement(List<Integer> arr) {
		List<Integer> nextGreaterElements = new ArrayList<>();
		
		if(arr == null || arr.size() == 0) {
			return nextGreaterElements;
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int n = arr.size();
		for(int i = n-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek() <= arr.get(i)) {
				stack.pop();
			}
			
			if(stack.isEmpty()) {
				nextGreaterElements.add(-1);
			} else {
				nextGreaterElements.add(stack.peek());
			}
			
			stack.push(arr.get(i));
		}
		
		Collections.reverse(nextGreaterElements);
		return nextGreaterElements;
	}
}
