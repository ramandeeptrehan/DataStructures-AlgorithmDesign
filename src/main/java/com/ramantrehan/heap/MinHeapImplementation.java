package com.ramantrehan.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
 * Should support 4 APIs:
 *  isEmpty(): Returns true if the heap is empty, false otherwise
	peek(): Returns the minimum item in the heap without removing it, if the heap is empty returns -1
	remove(): Returns the minimum item in the heap after removing it, if the heap is empty returns -1
	add(int value): Inserts an item with value value into the min-heap
 */

/*
 * 
 * 
    A min heap implementation

    Array Form: [ 5, 7, 6, 10, 15, 17, 12 ]

    Complete Binary Tree Form:
                    5
                /         \
            7               6
        /     \          /     \
      10      15        17      12

    Mappings:
      Parent -> (childIndex - 1) / 2
      Left Child -> 2 * parentIndex + 1
      Right Child -> 2 * parentIndex + 2
 */

public class MinHeapImplementation {

	private int capacity = 5;
	private int[] heap;
	private int size;
	
	public MinHeapImplementation() {
		this.heap = new int[capacity];
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new NoSuchElementException("Heap is empty.");
		}
		
		return heap[0];
	}
	
	public int remove() {
		if(isEmpty()) {
			throw new NoSuchElementException("Heap is empty");
		}
		
		//grab the item
		int minItem = heap[0];
		heap[0] = heap[size-1];
		size--;
		
		heapifyDown();
		
		return minItem;
	}
	
	public void add(int itemToAdd) {
		ensureExtraCapacity();
		
		heap[size] = itemToAdd;
		size++;
		
		shiftUp();
	}
	
	private void shiftUp() {
		int index = size-1;
		
		while(hasParent(index) && heap[index] < parent(index)) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		
		while(hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			//compare index element and smallerChildIndex
			if(heap[index] < heap[smallerChildIndex]) {
				break;
			} else {
				swap(index, smallerChildIndex);
			}
			
			index = smallerChildIndex;
		}
	}
	
	//helpers to access array easily
	private void swap(int indexOne, int indexTwo) {
		int temp = heap[indexOne];
		heap[indexOne] = heap[indexTwo];
		heap[indexTwo] = temp;
	}
	
	private void ensureExtraCapacity() {
		if(size == capacity) {
			capacity = capacity*2;
			heap = Arrays.copyOf(heap, capacity);
		}
	}
	
	private int getLeftChildIndex(int parentIndex) {
		return 2*parentIndex + 1;
	}
	
	private int getRightChildIndex(int parentIndex) {
		return 2*parentIndex + 2;
	}
	
	private int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
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
	
	private int leftChild(int index) {
		return heap[getLeftChildIndex(index)];
	}
	
	private int rightChild(int index) {
		return heap[getRightChildIndex(index)];
	}
	
	private int parent(int index) {
		return heap[getParentIndex(index)];
	}
}
