package com.ramantrehan.heap;


import java.util.PriorityQueue;

public class ConnectRopesMinimizeCost {
	
	public int findMinCost(int[] lengthOfRopes)
	{
		//merge 2 smallest ropes first 
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> (a-b));
		
		for(int length: lengthOfRopes) {
			minHeap.add(length);
		}
		
		//simulate
		int cost = 0;
		
		int smallestLength = 0;
		int nextSmallestLength = 0;
		
		while(minHeap.size() > 1) {
			smallestLength = minHeap.poll();
			nextSmallestLength = minHeap.isEmpty() ? 0 : minHeap.poll();
			
			cost += smallestLength + nextSmallestLength;
			
			minHeap.add(smallestLength + nextSmallestLength);
		}
		
		return cost;
	}
	
	public static void main(String[] args) {
		
		ConnectRopesMinimizeCost obj = new ConnectRopesMinimizeCost();
		
		int[] lengths = {5, 4, 2, 8};
		System.out.println("Minimum cost to connect ropes: " + obj.findMinCost(lengths));
	}
}
