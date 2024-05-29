import java.util.*;
class FloodFill{
	public static void main(String[] args){
		int[][] arr ={{1,1,1,},{1,1,0},{1,0,1}};
		int sr =1, sc=1,color=2;
		int m = arr.length,n = arr[0].length;
		int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
		int cur_color = arr[sr][sc];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{sr,sc});
		arr[sr][sc]=color;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int[] dir:directions){
				int newX = x+dir[0];
				int newY = y+dir[1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && arr[newX][newY]==cur_color){
					arr[newX][newY] = color;
					q.offer(new int[]{newX,newY});
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++) System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		
	}
}