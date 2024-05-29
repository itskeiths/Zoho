/*2.Given a square chessboard of N x N size, the position of the Knight and the position of a target
are given. We need to find out the minimum steps a Knight will take to reach the target position.*/

import java.util.*;

class MinSteps {
    static int[][] visited;
    static int[][] stepsToReach;
    static int[][] directions ={{-1,2},{1,2},{2,1},{2,-1},{-2,-1},{-2,1},{-1,-2},{1,-2}};
  

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the position of knight:");
        int kx = in.nextInt();
        int ky = in.nextInt();
        System.out.println("Enter the position of target:");
        int tx = in.nextInt();
        int ty = in.nextInt();
        System.out.println("Enter the size of board:");
        int n = in.nextInt();
        visited = new int[n][n];
        stepsToReach = new int[n][n];
        System.out.println("Minimum number of steps to reach: " + minSteps(kx, ky, tx, ty, n));
    }

    static int minSteps(int kx, int ky, int tx, int ty, int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{kx, ky});
        visited[kx][ky] = 1;
        while (!queue.isEmpty()) {
            int[] currPos = queue.poll();
            int x = currPos[0];
            int y = currPos[1];
            if (x == tx && y == ty) {
                return stepsToReach[x][y];
            }
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && visited[newX][newY] == 0) {
                    visited[newX][newY] = 1;
                    stepsToReach[newX][newY] = stepsToReach[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }
}

