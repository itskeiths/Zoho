import java.util.*;
class DungeonPit{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter dimensions:");
		int row = in.nextInt();
		int col = in.nextInt();
		System.out.println("Enter Position of adventerer:");
		int startx = in.nextInt();
		int starty = in.nextInt();
		startx--;
		starty--;
		System.out.println("Enter Position of Monster:");
		int monsterx = in.nextInt();
		int monstery = in.nextInt();
		monsterx--;
		monstery--;
		System.out.println("Enter Position of Gold:");
		int targetx = in.nextInt();
		int targety = in.nextInt();
		targetx--;
		targety--;
		int[][] pits = new int[row][col];
		System.out.println("Enter the number of pits");
		int n = in.nextInt();
		for(int i=0;i<n;i++){
			System.out.println("Enter position "+(i+1)+":"); 
			pits[in.nextInt()-1][in.nextInt()-1]=1;
		}
		int patha=bfs(startx,starty,targetx,targety,row,col,pits);
		int[][] empty = new int[row][col];
		int pathm=bfs(monsterx,monstery,targetx,targety,row,col,empty);
		if(patha<=pathm) System.out.println(patha);
		else System.out.println("Not possible");
	}
	
	static int bfs(int startx, int starty,int targetx, int targety,int row, int col,int[][] pits){
		int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
		int[][] movpath = new int[row][col];
		for(int[] rows: movpath) Arrays.fill(rows,-1);
		Queue<int[]> q = new LinkedList<>();
		movpath[startx][starty]=0;
		q.offer(new int[]{startx,starty});
		int path=0;
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			if(x==targetx && y==targety){
				break;
			}
			for(int[] dir:directions){
				int newX = x+dir[0];
				int newY = y+dir[1];
			if(newX>=0 && newX<row && newY>=0 && newY<col && movpath[newX][newY]==-1 && pits[newX][newY]!=1){
				q.offer(new int[]{newX,newY});
				path=1+movpath[x][y];
				movpath[newX][newY]=path;
			}
		}

	}
			/*for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				System.out.print(movpath[i][j]+" ");
			}
			System.out.println();
		}*/
	return movpath[targetx][targety];
	}
}