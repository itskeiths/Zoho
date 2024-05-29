/*Find minimum passes required to convert all negative values in a matrix*/

import java.util.*;
class MinPass{
	public static void main(String[] args){
		int[][] arr = {
			{-1,-9,0,-1,0},
			{-8,-3,-2,9,-7},
			{2,0,0,-6,0},
			{0,-7,-3,5,-4}};
		numberOfPass(arr);
	}
	
	public static void numberOfPass(int[][] arr){	
		int m = arr.length;
		int n = arr[0].length;
		int[][] directions = {{0,-1},{0,1},{-1,0},{1,0}};
		Queue<int[]> q = new LinkedList<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]>0) q.offer(new int[]{i,j});
			}
		}
		int pass = 0;
		while(!q.isEmpty()){
			int size = q.size();
			boolean hasChanged = false;
			for(int i=0;i<size;i++){
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				for(int[] dir:directions){
					int newX = x+dir[0];
					int newY = y+dir[1];
					if(newX>=0 && newX<m && newY>=0 && newY<n && arr[newX][newY]<0){
						arr[newX][newY]*=-1;
						q.offer(new int[]{newX,newY});
						hasChanged = true;
					}
				}
			}
			if(hasChanged) pass++;
		}
		System.out.println("Min pass needed to convert all negative to positive : "+pass);
	}
}