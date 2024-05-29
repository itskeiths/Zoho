/*4.Write a program to count the number of consecutive 1's formed by connecting adjacent 1's
horizontally and vertically in the 2D grid map of 0's and 1's*/

import java.util.*;
class Consecutive{
static int[][] visited;
static List<Choice> choices = new ArrayList<>(List.of(new Choice(0,1),new Choice(0,-1),new Choice(1,0),new Choice(-1,0)));
public static void main(String[] args){
int[][] matrix = {{0,0,1,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,0},{1,0,0,0,0}};
int m = matrix.length;
int n = matrix[0].length;
visited = new int[m][n];
System.out.println("Consecutive ones: "+consecutive(matrix,m,n));
}

static int consecutive(int[][] arr, int m, int n) {
    int maxCount = 0;
    Queue<int[]> q = new LinkedList<>();
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (arr[i][j] == 1) {
                int count = 0;
                q.offer(new int[]{i, j});
                visited[i][j] = 1;
                
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    int x = cur[0];
                    int y = cur[1];
                    count++;
                    
                    for (Choice c : choices) {
                        int newX = x + c.x;
                        int newY = y + c.y;
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n 
                            && visited[newX][newY] == 0 && arr[newX][newY] == 1) {
                            visited[newX][newY] = 1;
                            q.offer(new int[]{newX, newY});
                        }
                    }
                }
                maxCount = Math.max(maxCount, count);
            }
        }
    }
    return maxCount;
}

}

class Choice{
int x, y;
public Choice(int x, int y){
this.x=x;
this.y=y;
}
}