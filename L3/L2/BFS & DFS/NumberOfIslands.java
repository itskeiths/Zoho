import java.util.*;
class NumberOfIslands{
static int[][] matrix = {{0,0,1,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,0},{1,0,0,0,0}};
static int m = matrix.length;
static int n = matrix[0].length;
public static void main(String[] args){
int count=0;
int maxCount=0;
for(int i=0;i<m;i++){
for(int j=0;j<n;j++){
if(matrix[i][j]==1) 
{
  dfs(i,j);
  count++;
}
}
}
System.out.println("Number of Islands: "+count);
}

static void dfs( int x, int y){
	if(x<0 || x>=m || y<0 || y>=n || matrix[x][y]==0){
		return;
	}
	matrix[x][y]=0;
	dfs(x,y-1);
	dfs(x,y+1);
	dfs(x+1,y);
	dfs(x-1,y);
}
}