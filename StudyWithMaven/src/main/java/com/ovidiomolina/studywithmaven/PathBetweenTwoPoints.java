/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ovidiomolina.studywithmaven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author ovidiomolina
 */
public class PathBetweenTwoPoints {
    /**
     * [
     *  [1,0,0,1],
     *  [1,0,0,1],
     *  [1,1,1,1]
     * ]
     * @param maze
     * @param start
     * @param end
     * @return 
     */
    private static List<Point> pathBetweenPoints(int maze[][],
            Point start, Point end) {
        Stack<Point> stack = new Stack<>();
        List<Point> visited  = new ArrayList<>();
        boolean found = false;
        stack.add(start);
        while(!stack.isEmpty()) {
            Point current = stack.pop();
            visited.add(current);
            if(current.equals(end)) {
                found = true;
                break;
            }
            addNeighbors(current, stack, visited, maze);
        }
        if(!found) {
            return Collections.EMPTY_LIST;
        }
        return visited;
    }
    private static void addNeighbors(Point current, Stack<Point> stack, List<Point> visited, int maze[][]) {
        if(current.i + 1 < maze.length) {
            addPoint(current.i+1, current.j, stack, visited, maze);
        }
        if(current.i - 1 >= 0) {
            addPoint(current.i-1, current.j, stack, visited, maze);
        }
        if(current.j + 1 < maze[0].length) {
            addPoint(current.i, current.j+1, stack, visited, maze);
        }
        if(current.j - 1 >= 0) {
            addPoint(current.i, current.j-1, stack, visited, maze);
        }
    }
    
    private static void addPoint(int i, int j, Stack<Point> stack, List<Point> visited, int maze[][]) {
        if(maze[i][j] == 1) {
            Point newPoint = new Point(i, j);
            if(!visited.contains(newPoint)) {
                stack.add(newPoint);
            }
        }
    }
    
    public static void main(String args[]) {
        int maze[][] = new int[][]{
            {1,0,0,1},
            {1,0,0,1},
            {1,0,0,1},
            {1,1,1,1}
        };
        List<Point> path = pathBetweenPoints(maze, new Point(0,0), new Point(0,3));
        System.out.println(path.size());
    }
    
    static class Point {
        public int i;
        public int j;
        
        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
        
        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Point)) {
                return false;
            }
            Point p = (Point) obj;
            if (p == this) {
                return true;
            }
            return this.i == p.i && this.j == p.j;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 23 * hash + this.i;
            hash = 23 * hash + this.j;
            return hash;
        }
    }
    
}
