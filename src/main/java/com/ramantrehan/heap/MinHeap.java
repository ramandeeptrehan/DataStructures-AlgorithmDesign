package com.ramantrehan.heap;

import java.util.Arrays;

import lombok.Getter;

/*
 * Should support 4 APIs:
 *  isEmpty(): Returns true if the heap is empty, false otherwise
	peek(): Returns the minimum item in the heap without removing it, if the heap is empty returns -1
	remove(): Returns the minimum item in the heap after removing it, if the heap is empty returns -1
	add(int value): Inserts an item with value value into the min-heap
 */

@Getter
public class MinHeap {
	private int[] heap;
	private int size;
	private int capacity;
	
	public MinHeap(int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		
		return heap[0];
	}
	
	public int remove() {
		if(isEmpty()) {
			throw new RuntimeException("Heap is empty");
		}
		
		int minElement = heap[0];
		heap[0] = heap[size-1];
		size--;
		
		heapifyDown();
		
		return minElement;
	}

	public void add(int value) {
		ensureCapacity();
		
		heap[size] = value;
		size++;
		
		shiftUp();
	}
	
	private void heapifyDown() {
		int index = 0;
		
		int smallerValueIndex = 0;
		
		while(hasLeftChild(index)) {
			smallerValueIndex = getLeftChildIndex(index);
			
			if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
				smallerValueIndex = getRightChildIndex(index);
			}
			
			if(heap[index] <= heap[smallerValueIndex]) {
				break;
			} else {
				swap(index, smallerValueIndex);
				index = smallerValueIndex;
			}
		}
	}

	private void shiftUp() {
		int index = size-1;
		int parentIndex = 0;
		
		while(hasParent(index)) {
			parentIndex = getParentIndex(index);
			if(heap[index] < heap[parentIndex]) {
				swap(index, parentIndex);
				index = parentIndex;
			} else {
				break;
			}
		}
	}
	
	//helper methods
	private void ensureCapacity() {
		if(size == capacity) {
			capacity = capacity * 2;
			heap = Arrays.copyOf(heap, capacity);
		}
	}
	
	private void swap(int indexA, int indexB) {
		int temp = heap[indexA];
		heap[indexA] = heap[indexB];
		heap[indexB] = temp;
	}
	
	private int getLeftChildIndex(int index) {
		return 2*index + 1;
	}
	
	private int getRightChildIndex(int index) {
		return 2*index + 2;
	}
	
	private int getParentIndex(int index) {
		return (index-1)/2;
	}
	
	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	
	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	
	private boolean hasParent(int index) {
		return index!=0 && getParentIndex(index) >= 0;
	}
	
	private int getLeftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}
	
	private int getRightChild(int index) {
		return heap[getRightChildIndex(index)];
	}
	
	private int getParent(int index) {
		return heap[getParentIndex(index)];
	}
}
