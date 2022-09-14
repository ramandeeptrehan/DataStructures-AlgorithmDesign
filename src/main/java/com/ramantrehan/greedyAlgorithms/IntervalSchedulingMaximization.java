package com.ramantrehan.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalSchedulingMaximization {
	public List<List<Integer>> computeMaximalSetWithNoIntervals(int[][] intervals) {
		//use this approach: https://leetcode.com/problems/non-overlapping-intervals/
		
		List<List<Integer>> result = new ArrayList<>();
		
		if(intervals == null || intervals.length == 0) {
			return result;
		}
		
		Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));
		
		int[] intervalWindow = intervals[0];
		
		int n = intervals.length;
		List<Integer> list = null;
		
		for(int i = 1; i<n; i++) {
			if(intervalWindow[1] > intervals[i][0]) {
				//overlap
				intervalWindow[1] = Math.min(intervalWindow[1], intervals[i][1]);
			} else {
				//no overlap
				list = Arrays.asList(intervalWindow[0], intervalWindow[1]);
				result.add(list);
				
				intervalWindow = intervals[i];
			}
		}
		
		list = Arrays.asList(intervalWindow[0], intervalWindow[1]);
		result.add(list);
		
		return result;
	}
}
