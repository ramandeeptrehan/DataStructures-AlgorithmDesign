package com.ramantrehan.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeapImplementationPractice {
	private int capacity;
	private int[] heap;
	private int size;
	
	public MinHeapImplementationPractice(int capacity) {
		this.capacity = capacity;
		this.heap = new int[capacity];
		this.size = 0;
	}
	
	/*
	 * isEmpty
	 * peek
	 * remove
	 * add
	 * 
	 * 
	 */
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		}
		
		return heap[0];
	}
	
	public void add(int numberToAdd) {
		ensureExtraCapacity();
		
		heap[size] = numberToAdd;
		size++;
		
		shiftUp();
	}

	public int remove() {
		if(isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		}
		
		int min = heap[0];
		heap[0] = heap[size-1];
		size--;
		
		heapifyDown();
		
		return min;
	}

	private void heapifyDown() {
		int index = 0;
		int leftIndex = 0, rightIndex = 0;
		int smallerElementIndex = 0;
		while(hasLeftChild(index)) {
			leftIndex = getLeftChildIndex(index);
			smallerElementIndex = leftIndex;
			
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerElementIndex = getRightChildIndex(index);
			}
			
			if(heap[index] <= heap[smallerElementIndex]) {
				break;
			} else {
				swap(index, smallerElementIndex);
				index = smallerElementIndex;
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
	private void swap(int index, int smallerElementIndex) {
		int temp = heap[index];
		heap[index] = heap[smallerElementIndex];
		heap[smallerElementIndex] = temp;
	}
	
	private void ensureExtraCapacity() {
		if(size == capacity) {
			capacity = capacity * 2;
			heap = Arrays.copyOf(heap, capacity);
		}
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
		return index>0 && getParentIndex(index) >=0;
	}
	
	private int leftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return heap[getRightChildIndex(index)];
	}
	
	private int parentNode(int index) {
		return heap[getParentIndex(index)];
	}
}
