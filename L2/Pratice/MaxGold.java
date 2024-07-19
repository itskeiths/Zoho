class MaxGold{
	static int maxGold=0;
	public static void main(String[] args){
		int[][] mat = {{0,6,0},{5,8,7},{0,9,0}};
		int m = mat.length;
		int n = mat[0].length;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int[][] visited = new int[m][n];
				if(mat[i][j]!=0) dfs(mat,i,j,-1*mat[i][j],visited);
			}
		}
		System.out.println(maxGold);
	}
	
	static void dfs(int[][] mat , int start, int end, int gold,int[][]visited){
		if(start<0 || end<0 || start>=mat.length || end>=mat[0].length || visited[start][end]==1) return;
		visited[start][end] = 1;
		if(gold>maxGold) maxGold = gold;
		dfs(mat,start,end+1,mat[start][end]+gold,visited);
		dfs(mat,start,end-1,mat[start][end]+gold,visited);
		dfs(mat,start-1,end,mat[start][end]+gold,visited);
		dfs(mat,start+1,end,mat[start][end]+gold,visited);
	}
}