//Flood Fill algorithm

import java.util.*;
class FloodFill{
	public static void main(String[] args){
		int[][] img1 = {{1,1,1},{1,1,0},{1,0,1}};
		newImage(img1,1,1,2);
		System.out.println();
		int[][] img2 =
		{ 
		{1, 1, 1, 1, 1, 1, 1, 1}, 
		{1, 1, 1, 1, 1, 1, 0, 0}, 
		{1, 0, 0, 1, 1, 0, 1, 1}, 
		{1, 2, 2, 2, 2, 0, 1, 0}, 
		{1, 1, 1, 2, 2, 0, 1, 0}, 
		{1, 1, 1, 2, 2, 2, 2, 0}, 
		{1, 1, 1, 1, 1, 2, 1, 1}, 
		{1, 1, 1, 1, 1, 2, 2, 1}} ;	
		newImage(img2,4,4,3);
}
	
	static void newImage(int[][] img, int sr, int sc, int color){
		Queue<int[]> q = new LinkedList<>();
		int m = img.length;
		int n = img[0].length;
		int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
		int cur_color = img[sr][sc];
		img[sr][sc]=color;
		q.offer(new int[]{sr,sc});
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			for(int[] dir: directions){
				int newX= x+dir[0];
				int newY = y+dir[1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && img[newX][newY]==cur_color){
					img[newX][newY]=color;
					q.offer(new int[]{newX,newY});
				}
			}
		}
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++) System.out.print(img[i][j]+" ");
			System.out.println();
		}
		
	}
}