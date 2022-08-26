package com.ramantrehan.dynamicProgramming;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ZeroOneKnapsackTest {
	private ZeroOneKnapsack obj;
	
	@BeforeEach
	public void setup() {
		this.obj = new ZeroOneKnapsack();
	}
	
	@Test
	public void validScenario() {
		int value[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 50;
        int n = value.length;
        
        assertEquals(220, obj.maximizeProfit(weight, value, W, n));
        
        //memoized call
		obj.initializeTable(n+1, W+1);
        assertEquals(220, obj.maximizeProfitWithMemoization(weight, value, W, n));
        
        //top down
        assertEquals(220, obj.maximizeProfitWithTopDown(weight, value, W, n));
	}
	
	@Test
	public void validScenario2() {
		int value[] = {20, 5, 10, 40, 15, 25};
        int weight[] = {1, 2, 3, 8, 7, 4};
        int W = 10;
        int n = value.length;
        
        assertEquals(60, obj.maximizeProfit(weight, value, W, n));
        
        //memoized call
        obj.initializeTable(n+1, W+1);
        assertEquals(60, obj.maximizeProfitWithMemoization(weight, value, W, n));
	
        //top down
        assertEquals(60, obj.maximizeProfitWithTopDown(weight, value, W, n));
	}
	
	@Test
	public void validScenario3() {
		int value[] = {10, 20, 30, 40};
        int weight[] = {12, 13, 15, 19};
        int W = 10;
        int n = value.length;
        
        assertEquals(0, obj.maximizeProfit(weight, value, W, n));
        
        //memoized call
        obj.initializeTable(n+1, W+1);
        assertEquals(0, obj.maximizeProfitWithMemoization(weight, value, W, n));
        
        //top down
        assertEquals(0, obj.maximizeProfitWithTopDown(weight, value, W, n));
	}
}
