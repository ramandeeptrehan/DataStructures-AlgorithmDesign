package com.ramantrehan.graph;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MazeEscapePossibleOrNotTest {
	private MazeEscapePossibleOrNot obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new MazeEscapePossibleOrNot();
	}
	
	@Test
	public void testValidScenario() {
		int[][] blocked = {{0, 1}, {1, 0}};
		int[] source = {0, 0};
		int[] target = {0, 2};
		
		boolean result = obj.isEscapePossible(blocked, source, target);
		assertEquals(false, result);
	}
	
	@Test
	public void testValidScenarioWithSolidExample() {
		//this example is from backtobackswe
		//https://backtobackswe.com/platform/content/search-a-maze-for-an-exit/video
		obj.setBoundary(5);
		int[][] blocked = {{1, 0},
				{2,1}, {3,1},
				{0,2},
				{0,3}, {2,3}, {3,3}, {4,3}};
		int[] source = {0, 0};
		int[] target = {4, 4};
		
		boolean result = obj.isEscapePossible(blocked, source, target);
		assertEquals(true, result);
	}
}
