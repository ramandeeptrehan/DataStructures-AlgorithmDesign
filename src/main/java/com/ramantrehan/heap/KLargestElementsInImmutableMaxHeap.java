package com.ramantrehan.heap;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class HeapItem {
	int index;
	int value;
	
	public HeapItem(int index, int value) {
		this.index = index;
		this.value = value;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getValue() {
		return this.value;
	}
}

class MaxHeapComparator implements Comparator<HeapItem> {

	@Override
	public int compare(HeapItem o1, HeapItem o2) {
		return Integer.compare(o2.value, o1.value);
	}
}

public class KLargestElementsInImmutableMaxHeap {
	
	private static List<Integer> findKLargestElements(int[] immutableMaxHeapArray, int k) {
		PriorityQueue<HeapItem> maxCandidates = new PriorityQueue(10, new MaxHeapComparator());
		List<Integer> kLargest = new ArrayList<>();
		
		//add first element to heap
		maxCandidates.add(new HeapItem(0, immutableMaxHeapArray[0]));
		
		for(int i = 0; i<k; i++) {
			HeapItem maxItem = maxCandidates.poll();
			kLargest.add(maxItem.getValue());
			
			int index = maxItem.getIndex();
			
			int leftIndex = 2*index + 1;
			if(leftIndex<immutableMaxHeapArray.length) {
				maxCandidates.add(new HeapItem(leftIndex, immutableMaxHeapArray[leftIndex]));
			}
			
			int rightIndex = 2*index + 2;
			if(rightIndex<immutableMaxHeapArray.length) {
				maxCandidates.add(new HeapItem(rightIndex, immutableMaxHeapArray[rightIndex]));
			}
		}
		
		
		return kLargest;
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
		
		List<Integer> kSmallestElements = findKLargestElements(arr, k);
		
		for(int i = 0; i<kSmallestElements.size(); i++) {
			System.out.println(kSmallestElements.get(i));
		}
	}
	
}
