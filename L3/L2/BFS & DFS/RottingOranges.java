/*Rotting oranges*/

import java.util.*;

class RottingOranges {
    public static void main(String[] args) {
        int[][] oranges1 = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] oranges2 = {{2,1,1},{0,1,1},{1,0,1}};
        int[][] oranges3 = {{2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
        
        System.out.println("Number of minutes take to rotten: " + calculateMin(oranges1));
        System.out.println("Number of minutes take to rotten: " + calculateMin(oranges2));
        System.out.println("Number of minutes take to rotten: " + calculateMin(oranges3));
    }

    static int calculateMin(int[][] oranges) {
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = oranges.length;
        int n = oranges[0].length;
        int freshOranges = 0;
        int minutes = 0;
        
        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (oranges[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (oranges[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            boolean hasRotten = false;
            
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && oranges[newX][newY] == 1) {
                        q.offer(new int[]{newX, newY});
                        oranges[newX][newY] = 2;
                        freshOranges--;
                        hasRotten = true;
                    }
                }
            }
            
            if (hasRotten) minutes++;
        }
        
        return freshOranges == 0 ? minutes : -1;
    }
}
