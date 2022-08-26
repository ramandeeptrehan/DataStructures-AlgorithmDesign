package com.ramantrehan.dynamicProgramming;

public class ZeroOneKnapsack {
	
	private int[][] table;
	
	public void initializeTable(int rows, int columns) {
		this.table = new int[rows][columns];
		
		for(int i = 0; i<rows; i++) {
			for(int j = 0; j<columns; j++) {
				table[i][j] = -1;
			}
		}
	}
	
	//given weights and values, maximize profit you can capture in knapsack of weight W
	public int maximizeProfit(int[] weight, int[] value, int W, int n) {
		//base case
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(weight[n-1] > W) {
			return maximizeProfit(weight, value, W, n-1);
		}
		
		//case when weight[n-1] <= W
		else  {
			//2 choices: take the current item or ignore it
			return Math.max(value[n-1] + maximizeProfit(weight, value, W - weight[n-1], n-1),
					maximizeProfit(weight, value, W, n-1));
		}
	}
	
	public int maximizeProfitWithMemoization(int[] weight, int[] value, int W, int n) {
		//base case
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(table[n][W] != -1) {
			return table[n][W];
		}
		
		if(weight[n-1] > W) {
			table[n][W] = maximizeProfit(weight, value, W, n-1);
			return table[n][W];
		}
		
		//case when weight[n-1] <= W
		else  {
			//2 choices: take the current item or ignore it
			table[n][W] = Math.max(value[n-1] + maximizeProfit(weight, value, W - weight[n-1], n-1),
					maximizeProfit(weight, value, W, n-1));
			return table[n][W];
		}
	}
	
	public int maximizeProfitWithTopDown(int[] weight, int[] value, int W, int n) {
		int[][] table = new int[n+1][W+1];
		//base case
		for(int i = 0; i<=n; i++) {
			table[i][0] = 0;
		}
		
		for(int j = 0; j<=W; j++) {
			table[0][j] = 0;
		}
		
		//recursive steps
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=W; j++) {
				if(weight[i-1] > j) {
					table[i][j] = table[i-1][j];
				} else {
					table[i][j] = Math.max(value[i-1] + table[i-1][j-weight[i-1]], 
							table[i-1][j]);
				}
			}
		}
		
		return table[n][W];
	}
}
