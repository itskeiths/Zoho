import java.util.*;
class ShortestPath{
public static void main(String[] args){
int[][] arr = {
            {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 1, 1, 0, 0, 1}
        };
System.out.println("Shortest path from source to destionation is: "+shortestPath(arr,0,0,7,5));
}

public static int shortestPath(int[][] arr,int srcx,int srcy,int desx,int desy){
	int m = arr.length;
	int n = arr[0].length;
	int[][] directions ={{0,-1},{0,1},{-1,0},{1,0}};
	int steps[][] = new int[m][n];
	Queue<int[]> q = new LinkedList<>();
	q.offer(new int[]{srcx,srcy});
	while(!q.isEmpty()){
		int[] cur = q.poll();
		int x = cur[0];
		int y = cur[1];
		if(x==desx && y==desy) return steps[x][y];
		for(int[] dir:directions){
			int newX = x+dir[0];
			int newY = y+dir[1];
			if(newX>=0 && newX<m && newY>=0 && newY<n && arr[newX][newY]==1){
				q.offer(new int[]{newX,newY});
				steps[newX][newY] = 1+ steps[x][y];
				arr[newX][newY]=0;
			}
		}
	}
	return -1;
	
}
}