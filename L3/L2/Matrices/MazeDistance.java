/*8.There is a ball in a maze with empty spaces and walls. The ball can go through
empty spaces by rolling up,down,left or right, but it won't stop rolling until
hitting a wall. When the ball stops, it could choose the next direction.
Given the ball's start position, the destination and the maze, find the shortest
distance for the ball to stop at the destination. The distance is defined by the
number of empty spaces traveled by the ball from the start position (excluded) to
the destination (included). If the ball cannot stop at the destination, return
-1.
The maze is represented by a binary 2D array. 1 means the wall and 0 means the
empty space. You may assume that the borders of the maze are all walls. The
start and destination coordinates are represented by row and column indexes.*/

import java.util.*;

public class MazeDistance {
    static int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] dir : dirs) {
                int x = curr[0];
                int y = curr[1];
                int count = 0;
                while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }
                x -= dir[0];
                y -= dir[1];
                count--;
                
                if (distance[curr[0]][curr[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[curr[0]][curr[1]] + count;
                    queue.add(new int[]{x, y});
                }
            }
        }
        
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 1},
            {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {1,4};
        int shortestDistance = shortestDistance(maze, start, destination);
        System.out.println("Shortest distance: " + shortestDistance);
    }
}
