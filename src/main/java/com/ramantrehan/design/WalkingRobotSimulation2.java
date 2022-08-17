package com.ramantrehan.design;

import java.util.HashMap;
import java.util.Map;

enum Direction {
    EAST,
    SOUTH,
    WEST,
    NORTH
}

class Position {
    int x;
    int y;
    Direction direction;
    
    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", direction=" + direction + "]";
	}
}

public class WalkingRobotSimulation2 {
    
    int[][] matrix;
    Position position;

    public WalkingRobotSimulation2(int width, int height) {
        //rows: height
        //columns: width
        this.matrix = new int[height][width];
        this.position = new Position(0, 0, Direction.EAST);
    }
    
    private boolean isSafe(int x, int y) {
        
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        if(x<0 || x>=columns || y<0 || y>=rows) {
            return false;
        }
        
        return true;
    }
    
    private void moveAStep(int x, int y, Direction direction, Direction[] directionArray, Map<Direction, Position> directionMap) {
        Position movePair = directionMap.get(direction);
        Direction directionToTake = direction;
        
        int newX = x + movePair.x;
        int newY = y + movePair.y;
        
        int index = 1;
        
        while(!isSafe(newX, newY)) {
            //rotate
            directionToTake = directionArray[index];
            index++;
            
            movePair = directionMap.get(directionToTake);
            newX = x + movePair.x;
            newY = y + movePair.y;
        }
        
        //newX and newY are safe
        this.position = new Position(newX, newY, directionToTake);
    }
    
    public void step(int num) {
        
        Map<Direction, Position> directionMap = new HashMap<>();
        directionMap.put(Direction.EAST, new Position(1, 0));
        directionMap.put(Direction.NORTH, new Position(0, 1));
        directionMap.put(Direction.WEST, new Position(-1, 0));
        directionMap.put(Direction.SOUTH, new Position(0, -1));

        
        Position currentPosition = position;
        int newX = 0, newY = 0;
        int x = 0, y = 0;
        
        Direction[] east = {Direction.EAST, Direction.NORTH, Direction.WEST, Direction.SOUTH};
        Direction[] north = {Direction.NORTH, Direction.WEST, Direction.SOUTH, Direction.EAST};
        Direction[] west = {Direction.WEST, Direction.SOUTH, Direction.EAST, Direction.NORTH};
        Direction[] south = {Direction.SOUTH, Direction.EAST, Direction.NORTH, Direction.WEST};

        for(int step = 1; step<=num; step++) {
            //move robot's position
            x = currentPosition.x;
            y = currentPosition.y;
            switch(currentPosition.direction) {
                case EAST:
                    moveAStep(x, y, Direction.EAST, east, directionMap); 
                    break;
                case NORTH:
                    moveAStep(x, y, Direction.NORTH, north, directionMap); 
                    break;
                case WEST:
                    moveAStep(x, y, Direction.WEST, west, directionMap); 
                    break;
                case SOUTH:
                    moveAStep(x, y, Direction.SOUTH, south, directionMap); 
                    break;
                default:
                    break;
            }
        }
    }
    
    public int[] getPos() {
        return new int[] {this.position.x, this.position.y};
    }
    
    public String getDir() {
        return this.position.direction.name();
    }
    
    public static void main(String[] args) {
    	WalkingRobotSimulation2 obj = new WalkingRobotSimulation2(6, 3);
    	obj.step(1);
    	System.out.println(obj.getDir() + " " + obj.getPos());
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
