package com.ramantrehan.heap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinHeapTest {
	
	private MinHeap minHeap;
	
	@BeforeEach
	public void setup() {
		this.minHeap = new MinHeap(5);
	}

	@Test
	public void testEmptyHeapExceptions() {
		assertThrows(RuntimeException.class, () -> {
			minHeap.peek();
		});
		
		assertThrows(RuntimeException.class, () -> {
			minHeap.remove();
		});
		
		assertTrue(minHeap.isEmpty());
	}
	
	@Test
	public void testSizeOfHeap() {
		minHeap.add(100);
		minHeap.add(2);
		minHeap.add(4);
			
		assertFalse(minHeap.isEmpty());
		assertEquals(2, minHeap.peek());
		assertEquals(3, minHeap.getSize());
	}
	
	@Test
	public void testRemoval() {
		minHeap.add(100);
		minHeap.add(-30);
		minHeap.add(4);
		minHeap.add(20);
		minHeap.add(50);
			
		assertFalse(minHeap.isEmpty());
		assertEquals(-30, minHeap.peek());
		assertEquals(5, minHeap.getSize());
		
		assertEquals(-30, minHeap.peek());
		assertEquals(-30, minHeap.remove());
		assertEquals(4, minHeap.peek());
		assertEquals(4, minHeap.remove());
		assertEquals(20, minHeap.peek());
		assertEquals(20, minHeap.remove());
		assertEquals(50, minHeap.peek());
		assertEquals(50, minHeap.remove());
		assertEquals(100, minHeap.peek());
		assertEquals(100, minHeap.remove());
		
		//now heap is empty
		assertTrue(minHeap.isEmpty());
		assertThrows(RuntimeException.class, () -> {
			minHeap.peek();
		});
		
		assertThrows(RuntimeException.class, () -> {
			minHeap.remove();
		});
	}
	
	@Test
	public void testCapacityIncrease() {
		assertEquals(5, minHeap.getCapacity());

		minHeap.add(100);
		minHeap.add(-30);
		minHeap.add(4);
		minHeap.add(20);
		minHeap.add(50);
		
		assertEquals(5, minHeap.getCapacity());
		
		minHeap.add(-80);
		
		assertEquals(5*2, minHeap.getCapacity());
		
		minHeap.add(3000);
		
		assertEquals(5*2, minHeap.getCapacity());
	}
}
