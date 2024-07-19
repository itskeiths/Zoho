import java.util.*;
class CatcusWall{
	static int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
	public static void main(String[] args){
		char[][] sand={{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'},{'.','.','.','.','.'}};
		//char[][] sand = {{'#','.','.'},{'.','#','.'},{'#','.','#'},{'.','.','.'}};
		//char[][] sand = {{'.','#','.','.'},{'.','.','#','.'}};
		//char[][] sand = {{'#','.','.'},{'.','#','.'},{'#','.','#'},{'.','.','.'}};
		int m = sand.length;
		int n = sand[0].length;
		
		for(int j=0;j<n;j++){
			for(int i=0;i<m;i++){
				if(!isPath(sand,0,0,m,n)){
					System.out.println("YES");
					display(sand,m,n);
					return;
				}
				
				if(sand[i][j]!='#') buildCatcus(i,j,m,n,sand);
			}
		}
	
		System.out.println("NO");
	}
	
	static void buildCatcus(int x, int y, int m, int n , char[][] sand){
			boolean isWall = true;
			for(int[] d:directions){
				int newX = x+d[0];
				int newY = y+d[1];
				if(newX>=0 && newX<m && newY>=0 && newY<n && sand[newX][newY]!='.'){	
						isWall=false;
						break;
				}
			}
			if(isWall){
				sand[x][y]='#';
				//display(sand,m,n);
				//System.out.println();
			}
	}
	
	static void display(char[][] sand,int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(sand[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	static boolean isPath(char[][] sand, int startx, int starty,int m , int n){
		int[][] visited = new  int[m][n];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{startx,starty});
		visited[startx][starty]=0;
		while(!q.isEmpty()){
		int[] cur =q.poll();
		int x = cur[0];
		int y = cur[1];
		if(x==m-1) return true;
		for(int[] dir:directions){
			int newX = x+dir[0];
			int newY = y+dir[1];
			if(newX>=0 && newX<m && newY>=0 && newY<n && visited[newX][newY]==0 && sand[newX][newY]!='#'){
				visited[newX][newY]=1;
				q.offer(new int[]{newX,newY});

			}
		}
		}		
		return false;
	
	}
}