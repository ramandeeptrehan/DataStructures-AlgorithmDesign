package com.ramantrehan.greedyAlgorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalSchedulingMaximizationTest {
	private IntervalSchedulingMaximization obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new IntervalSchedulingMaximization();
	}
	
	@Test
	public void testvalidScenario1() {
		int[][] intervals = { 
							  {1,2},
							  {2,3},
							  {3,4},
							  {1,3}
							};
		
		List<List<Integer>> expected = List.of(List.of(1,2), List.of(2,3), List.of(3,4));
		List<List<Integer>> result = obj.computeMaximalSetWithNoIntervals(intervals);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testvalidScenario2() {
		int[][] intervals = { 
							  {0, 3},
							  {0, 6}
							};
		
		List<List<Integer>> expected = List.of(List.of(0, 3));
		List<List<Integer>> result = obj.computeMaximalSetWithNoIntervals(intervals);
		
		assertEquals(expected, result);
	}
	
	@Test
	public void testvalidScenario3() {
		int[][] intervals = { 
								{0, 3},
								{0, 6},
								{0, 17},
								{8, 11},
								{19, 23}
							};
		
		List<List<Integer>> expected = List.of(List.of(0, 3), List.of(8, 11), List.of(19, 23));
		List<List<Integer>> result = obj.computeMaximalSetWithNoIntervals(intervals);
		
		assertEquals(expected, result);
	}
}
