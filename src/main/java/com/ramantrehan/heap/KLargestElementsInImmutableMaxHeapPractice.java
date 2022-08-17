package com.ramantrehan.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class HeapItemPractice {
	int value;
	int index;
	
	public HeapItemPractice(int value, int index) {
		this.value = value;
		this.index = index;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getIndex() {
		return this.index;
	}
}

class MaxHeapComparatorPractice implements Comparator<HeapItemPractice> {

	@Override
	public int compare(HeapItemPractice o1, HeapItemPractice o2) {
		return Integer.compare(o2.getValue(), o1.getValue());
	}
}

public class KLargestElementsInImmutableMaxHeapPractice {
	
	private static List<Integer> findKLargestElements(int[] arr, int k) {
		PriorityQueue<HeapItemPractice> maxHeap = new PriorityQueue<>(new MaxHeapComparatorPractice());
		List<Integer> kLargestElements = new ArrayList<>();
		
		maxHeap.add(new HeapItemPractice(arr[0], 0));
		
		HeapItemPractice heapItem = null;
		int index = 0;
		int leftIndex = 0, rightIndex = 0;
		
		for(int i = 0; i<k; i++) {
			heapItem = maxHeap.poll();
			kLargestElements.add(heapItem.getValue());
			
			index = heapItem.getIndex();
			
			leftIndex = 2*index + 1;
			if(leftIndex < arr.length)
				maxHeap.add(new HeapItemPractice(arr[leftIndex], leftIndex));
			
			rightIndex = 2*index + 2;
			if(rightIndex < arr.length)
				maxHeap.add(new HeapItemPractice(arr[rightIndex], rightIndex));
		}
		
		return kLargestElements;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter n: ");
		int n = in.nextInt();
		
		System.out.println("Enter " + n + " elements");
		
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = in.nextInt();
		}
		
		System.out.println("Enter k: ");
		int k = in.nextInt();
		
		List<Integer> kLargestElements = findKLargestElements(arr, k);
		
		for(int element: kLargestElements) {
			System.out.println(element);
		}
	}

	
}
