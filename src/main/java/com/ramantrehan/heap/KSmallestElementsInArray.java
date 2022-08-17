package com.ramantrehan.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KSmallestElementsInArray {
	
	private static List<Integer> findKSmallestElements(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
		
		for(int element: arr) {
			maxHeap.add(element);
			
			if(maxHeap.size() == k+1) {
				maxHeap.poll();
			}
		}
		
		return new ArrayList<>(maxHeap);
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
		
		List<Integer> kSmallestElements = findKSmallestElements(arr, k);
		
		for(int i = 0; i<kSmallestElements.size(); i++) {
			System.out.println(kSmallestElements.get(i));
		}
	}

}
