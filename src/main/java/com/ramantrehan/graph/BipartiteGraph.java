package com.ramantrehan.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

enum GraphColor {
	UNCOLORED,
	BLACK,
	WHITE
}

public class BipartiteGraph {
	public boolean isBipartite(List<List<Integer>> graph) {
		
		Set<Integer> visited = new HashSet<>();
		Map<Integer, GraphColor> graphColor = new HashMap<>();
		
		assignInitialColors(graph, graphColor);
		
		//graph could be disconnected
		Set<Integer> vertexSet = graphColor.keySet();
		
		Queue<Integer> queue = new LinkedList<>();
		
		Integer node = null;
		
		for(int vertex: vertexSet) {
			if(!visited.contains(vertex)) {
				visited.add(vertex);
				graphColor.put(vertex, GraphColor.WHITE);
				
				queue.add(vertex);
				
				while(!queue.isEmpty()) {
					node = queue.remove();
					
					for(int neighbor: graph.get(node)) {
						
					}
				}
			}
		}
		return false;
	}

	private void assignInitialColors(List<List<Integer>> graph, Map<Integer, GraphColor> graphColor) {
		for(List<Integer> edges: graph) {
			for(Integer node: edges) {
				if(!graphColor.containsKey(node)) {
					graphColor.put(node, GraphColor.UNCOLORED);
				}
			}
		}
	}
}
