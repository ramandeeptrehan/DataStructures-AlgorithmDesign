package com.ramantrehan.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Coordinate {
    int x;
    int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    @Override
    public boolean equals(Object o) {
        if(this == o) {
            return true;
        }
        
        if(o == null || this.getClass()!=o.getClass()) {
            return false;
        }
        
        Coordinate other = (Coordinate) o;
        
        return this.x == other.x && this.y == other.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return this.getX() + " " + this.getY();
    }
}

public class MazeEscapePossibleOrNot {
	
	List<Coordinate> finalPath = new ArrayList<>();
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    int boundary = 1000000;
    
    public void setBoundary(int newBoundary) {
    	this.boundary = newBoundary;
    }
    
    private boolean isSafe(Coordinate coordinate, Set<Coordinate> visited, Set<Coordinate> blockedSet) {
        if(coordinate.getX()<0 || coordinate.getX()>=boundary) {
            return false;
        }
        
        if(coordinate.getY()<0 || coordinate.getY()>=boundary) {
        	return false;
        }
        
        return blockedSet.contains(coordinate) == false && visited.contains(coordinate) == false;
    }
    
    private boolean DFS(Set<Coordinate> visited, Set<Coordinate> blockedSet, Coordinate source, Coordinate target, List<Coordinate> path) {
        visited.add(source);
        path.add(source);
        
        if(source.equals(target)) {
            finalPath = new ArrayList<>(path);
            
            for(Coordinate coordinate: finalPath) {
                System.out.println(coordinate);
            }
            
            return true;
        }
        
        for(int k = 0; k<4; k++) {
            int newX = source.getX() + dx[k];
            int newY = source.getY() + dy[k];
            
            if(isSafe(new Coordinate(newX, newY), visited, blockedSet)) {
                if(DFS(visited, blockedSet, new Coordinate(newX, newY), target, path)) {
                    return true;
                }
            }
        }
        
        path.remove(path.size()-1);
        return false;
    }
    
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Set<Coordinate> visited = new HashSet<>();
        Set<Coordinate> blockedSet = new HashSet<>();
        
        for(int[] blockedEntry: blocked) {
            blockedSet.add(new Coordinate(blockedEntry[0], blockedEntry[1]));
        }
        
        List<Coordinate> path = new ArrayList<>();
        
        return DFS(visited, blockedSet, new Coordinate(source[0], source[1]), new Coordinate(target[0], target[1]), path);
    }

}
